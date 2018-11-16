-- Exercice 1

-- R1

EXPLAIN PLAN SET statement_id = 'r11' FOR
SELECT code_insee
FROM imougenot.commune;

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

EXPLAIN PLAN SET statement_id = 'r11' FOR
SELECT /*+ NO_INDEX(imougenot.commune) */ code_insee
FROM imougenot.commune;

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

-- R2

EXPLAIN PLAN SET statement_id = 'r12' FOR
SELECT nom_com
FROM imougenot.commune;

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

EXPLAIN PLAN SET statement_id = 'r12' FOR
SELECT /*+ NO_INDEX(imougenot.commune) */ nom_com
FROM imougenot.commune;

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

-- R3

EXPLAIN PLAN SET statement_id = 'r13' FOR
SELECT nom_com, code_insee
FROM imougenot.commune ;

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

EXPLAIN PLAN SET statement_id = 'r13' FOR
SELECT /*+ NO_INDEX(imougenot.commune) */ nom_com, code_insee
FROM imougenot.commune ;

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

-- R4

EXPLAIN PLAN SET statement_id = 'r14' FOR
SELECT nom_com
FROM imougenot.commune WHERE code_insee='34192';

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

EXPLAIN PLAN SET statement_id = 'r14' FOR
SELECT /*+ NO_INDEX(imougenot.commune) */ nom_com
FROM imougenot.commune WHERE code_insee='34192';

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

-- R5

EXPLAIN PLAN SET statement_id = 'r15' FOR
SELECT nom_com
FROM imougenot.commune
WHERE code_insee like '34%';

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

EXPLAIN PLAN SET statement_id = 'r15' FOR
SELECT /*+ NO_INDEX(imougenot.commune) */ nom_com
FROM imougenot.commune
WHERE code_insee like '34%';

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

-- R6

EXPLAIN PLAN SET statement_id = 'r16' FOR
SELECT nom_com
FROM imougenot.commune
WHERE code_insee like '%392';

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

-- R7

EXPLAIN PLAN SET statement_id = 'r17' FOR
SELECT nom_com
FROM imougenot.commune
WHERE code_insee >= 34;

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

EXPLAIN PLAN SET statement_id = 'r17' FOR
SELECT /*+ NO_INDEX(imougenot.commune) */ nom_com
FROM imougenot.commune
WHERE code_insee >= 34;

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

-- R8

EXPLAIN PLAN SET statement_id = 'r18' FOR
SELECT nom_com
FROM imougenot.commune
WHERE code_insee IN ('09330','09331','09332','09334');

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

EXPLAIN PLAN SET statement_id = 'r18' FOR
SELECT /*+ NO_INDEX(imougenot.commune) */ nom_com
FROM imougenot.commune
WHERE code_insee IN ('09330','09331','09332','09334');

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

-- Exercice 2

EXPLAIN PLAN SET statement_id = 'r21' FOR
SELECT *
FROM imougenot.commune
WHERE nom_com LIKE 'MO%';

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

EXPLAIN PLAN SET statement_id = 'r22' FOR
SELECT *
FROM imougenot.departement
WHERE dep > 24
AND dep < 46;

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

EXPLAIN PLAN SET statement_id = 'r23' FOR
SELECT nom_com, nom_dep, nom_reg
FROM imougenot.commune c
INNER JOIN imougenot.departement d ON d.dep = c.dep
INNER JOIN imougenot.region r ON d.reg = r.reg;

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

EXPLAIN PLAN SET statement_id = 'r24' FOR
SELECT count(*) AS com, nom_dep, d.dep
FROM imougenot.commune c
INNER JOIN imougenot.departement d ON c.dep = d.dep
GROUP BY d.dep, d.nom_dep;

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

CREATE INDEX 'index_commune_dep' ON 'commune' ('dep');
CREATE INDEX 'index_departement_dep' ON 'departement' ('dep');
CREATE INDEX 'index_departement_reg' ON 'departement' ('reg');
CREATE INDEX 'index_region_reg' ON 'region' ('reg');

SELECT *
FROM user_indexes;

EXPLAIN PLAN SET statement_id = 'r23' FOR
SELECT nom_com, nom_dep, nom_reg
FROM imougenot.commune c
INNER JOIN imougenot.departement d ON d.dep = c.dep
INNER JOIN imougenot.region r ON d.reg = r.reg;

SELECT plan_table_output
FROM table(dbms_xplan.display());

SELECT plan_id, cpu_cost, io_cost, optimizer, operation
FROM plan_table;

-- Exercice 3

-- Exercice 4

--TODO

-- Exercice 5

SET serveroutput ON size 30000;
SET linesize 150;

CREATE OR REPLACE PACKAGE dm AS
  PROCEDURE printTree;
END dm;
/

CREATE OR REPLACE PACKAGE BODY dm AS
  PROCEDURE printTree IS
    CURSOR c IS SELECT plan_table_output
    FROM table(dbms_xplan.display());

    BEGIN
      dbms_output.put_line('');
      dbms_output.put_line('--------------------------------------------------------------------------------------------------------');
      FOR t IN c LOOP
        dbms_output.put_line('');
      END LOOP;
    END;
END dm;
/
