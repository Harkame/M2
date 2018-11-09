CREATE TABLE departement AS SELECT * FROM imougenot.departement;
CREATE TABLE region AS SELECT * FROM imougenot.region;

--1989
EXPLAIN PLAN SET statement_id = 'pe4' FOR
SELECT nom_com, latitude, longitude
FROM imougenot.commune c, imougenot.departement d, imougenot.region r
WHERE c.nom_com LIKE 'M%'
AND c.dep = d.dep
AND d.reg = r.reg
AND r.nom_reg LIKE 'LANGUEDOC-ROUSSILLON';

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

--1982
EXPLAIN PLAN SET statement_id = 'pe4' FOR
SELECT nom_com, latitude, longitude
FROM imougenot.commune c
INNER JOIN imougenot.departement d ON c.dep = d.dep
INNER JOIN imougenot.region r ON d.reg = r.reg
WHERE c.nom_com LIKE 'M%'
AND r.nom_reg LIKE 'LANGUEDOC-ROUSSILLON';

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

-- Le plan d'execution est le meme pour les deux requetes, c'est le premier arbre qui
-- est choisie (pas l'opti)
-- Apres refresh des stats, les estimations vont changer (etre plus precises)

-- in
EXPLAIN PLAN SET statement_id = 'pe4' FOR
SELECT nom_com, latitude, longitude
FROM imougenot.commune c
WHERE c.nom_com LIKE 'M%'
AND c.dep IN
(
  SELECT dep
  FROM imougenot.departement d
  WHERE d.reg IN
  (
    SELECT reg
    FROM imougenot.region r
    WHERE nom_reg LIKE 'LANGUEDOC-ROUSSILON'
  )
);

-- exist
EXPLAIN PLAN SET statement_id = 'pe4' FOR
SELECT nom_com, latitude, longitude
FROM imougenot.commune c
WHERE c.nom_com LIKE 'M%'
AND EXISTS
(
  SELECT dep
  FROM imougenot.departement d
  WHERE c.dep = d.dep
  AND EXISTS
  (
    SELECT reg
    FROM imougenot.region r
    WHERE d.reg = r.reg
    AND nom_reg LIKE 'LANGUEDOC-ROUSSILON'
  )
);

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

CREATE OR REPLACE PROCEDURE ShowPlan IS

END;
