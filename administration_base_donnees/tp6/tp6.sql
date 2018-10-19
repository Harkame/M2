CREATE TABLE commune AS SELECT * FROM imougenot.commune;

ALTER TABLE commune
ADD CONSTRAINT commune_pk PRIMARY KEY (code_insee);

SELECT index_name, index_type, blevel, uniqueness, num_rows
FROM user_indexes
WHERE table_name = 'COMMUNE';

analyze index commune_pk validate structure;

analyze table commune compute statistics;

SELECT lf_rows AS tupleFeuille, lf_blks AS BLOCSFEUILLE, lf_rows_len AS TAILLEFEUILLE, br_rows AS TUPLEBRANCHE, br_blks AS BLOCSBRANCHE, br_rows_len AS TAILLEBRANCHE
FROM index_stats;

-- 82 = 81 pointeurs sur les feuilles + 1 racine

SELECT rowid, rownum, code_insee
FROM commune;

--5
SELECT blocks, segment_name, segment_type
FROM dba_segments
WHERE owner = 'LDAVIAUD'
AND segment_type = 'INDEX';

--Taille moyenne d'un tuple

SELECT table_name, avg_row_len
FROM user_tables;

set serveroutput on;

DECLARE
  object_no integer;
  row_no integer;
  row_id ROWID;
BEGIN
  SELECT ROWID INTO row_id FROM commune
  WHERE code_insee = '34172';
  object_no := DBMS_ROWID.ROWID_OBJECT(row_id);
  row_no := DBMS_ROWID.ROWID_ROW_NUMBER(row_id);
  DBMS_OUTPUT.PUT_LINE('The obj. # is '||object_no||' '||row_no);
END;
/

SELECT DBMS_ROWID.ROWID_BLOCK_NUMBER(rowid), DBMS_ROWID.ROWID_OBJECT(rowid), nom_com
FROM commune where code_insee = '34172';

SELECT DBMS_ROWID.ROWID_BLOCK_NUMBER(rowid), count(*)
FROM commune GROUP BY DBMS_ROWID.ROWID_BLOCK_NUMBER(rowid);

CREATE OR REPLACE PROCEDURE memeQue (code in varchar) AS
  cursor c IS
  SELECT c1.code_insee, c1.nom_com, DBMS_ROWID.ROWID_BLOCK_NUMBER(c1.rowid) as numBlock
  FROM commune c1, commune c2
  WHERE DBMS_ROWID.ROWID_BLOCK_NUMBER(c1.rowid) = DBMS_ROWID.ROWID_BLOCK_NUMBER(c2.rowid)
  AND c2.code_insee = code
  AND c1.code_insee <> code;

  BEGIN
    FOR c_t IN c LOOP
      DBMS_OUTPUT.PUT_LINE(c_t.code_insee||' '||c_t.nom_com||' '||c_t.numBlock||' '||code);
    END LOOP;
END;
/

exec memeQue(34172);

1. select code insee from commune; Oui, parcours total des blocs d index, car clé primaire
2. select nom Com from commune; Non, parcours total de la table
3. select nom Com, code insee from commune; Non, car nom_com n est pas dans l index, il faut aller dans les blocs de données
4. select nom Com from commune where code insee=’34192’; Oui
5. select nom Com from commune where code insee like ’34%’; Oui, car le % est au debut, %34 n utilise pas l index
6. select nom Com from commune where code insee >= 34; Non, car fonction de conversion
7. select nom Com from commune where code insee in (’09330’,’09331’,’09332’,’09334’); Oui, car recherche sur differente valeur, revient a une recherche par intervalle

CREATE INDEX com_idx ON commun(nom_com);
