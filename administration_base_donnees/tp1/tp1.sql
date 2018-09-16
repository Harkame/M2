ALTER TABLE emp
ADD CONSTRAINT emp_pk primary key(num);

ALTER TABLE dept
ADD CONSTRAINT dept_pk primary key (n_dept);

UPDATE emp SET n_dept = 10 WHERE n_dept=100;

ALTER TABLE emp
ADD CONSTRAINT emp_fkl FOREIGN KEY (n_dept) references dept(n_dept) on delete cascade;

ALTER TABLE emp
ADD CONSTRAINT emp_fk2 FOREIGN KEY (n_sup) references emp(num) on delete cascade;

SELECT constraint_name, constraint_type
FROM user_constraintsALTER TABLE emp
ADD CONSTRAINT emp_pk primary key(num);

ALTER TABLE dept
ADD CONSTRAINT dept_pk primary key (n_dept);

UPDATE emp SET n_dept = 10 WHERE n_dept=100;

ALTER TABLE emp
ADD CONSTRAINT emp_fkl FOREIGN KEY (n_dept) references dept(n_dept) on delete cascade;

--ALTER TABLE emp
--WHERE table_name IN ('emp', 'dept');

1)

CREATE OR REPLACE TRIGGER salary_positive
  BEFORE INSERT OR UPDATE OF salaire ON emp
  FOR EACH ROW
  BEGIN
    IF :new.salaire < 0 then
        raise_application_error(-20000, 'Nop. Salaire < 0');
    END IF;
  END;
/

UPDATE emp
SET salaire = -42
WHERE num = 24831;

INSERT INTO emp VALUES
	('TOTO',984,'administratIF', 16712,'10-SEP-08',-98,NULL,30);

CREATE OR REPLACE TRIGGER salary_smic
BEFORE INSERT OR UPDATE OF salaire ON emp
FOR EACH ROW

DECLARE
  CURSOR citys IS SELECT * FROM dept WHERE NOM = 'Rennes';

BEGIN
  dbms_output.put_line('NOUVEAU SALAIRE : '||:new.salaire);

  for city IN citys LOOP
    IF :new.salaire < 1000 AND city.n_dept = :new.n_dept then
      raise_application_error(-20000, 'Nop. Salaire < 1000 sur rennes');
    END IF;
  END loop;
END;
/

CREATE OR REPLACE TRIGGER salary_smic
  BEFORE INSERT OR UPDATE OF salaire ON emp
  FOR EACH ROW

  DECLARE
  location dept.lieu%type;

  BEGIN
    dbms_output.put_line('n_dept : ' ||:new.salaire);

    SELECT lieu INTO location
    FROM dept
    WHERE n_dept = :new.n_dept;

    IF :new.salaire < 1000 AND location = 'Rennes' then
      raise_application_error(-20000, 'Nop. SAlaire trop bas');
    END IF;
  END;
/

INSERT INTO emp VALUES('Dark-Sasuke',21831,'administratIF', 16712,'10-SEP-08', 500,NULL, 10);

Vous reprendrez l’´ecriture du trigger ouvrable. Vous d´eﬁnirez une proc´edure JoursEtHeuresOuvrables sans argument qui v´eriﬁe que
la date du jour n’est pas un samedi ni un dimanche et qui renvoie un message d’erreur autrement. Vous red´eﬁnirez le trigger ouvrable qui fera appel
a cette proc´edure, dans le contexte de la table Emp. Vous en testerez les eﬀets.

CREATE OR REPLACE PROCEDURE JoursEtHeuresOuvrables IS
  current_day NUMBER;
  BEGIN
    SELECT to_char (CURRENT_DATE, 'D') into current_day FROM dual;

    IF current_day = 6 OR current_day = 7 THEN
  	 raise_application_error(-20000, 'Closed');
    END IF;
  END;


CREATE OR REPLACE TRIGGER trigger_available_day
  BEFORE INSERT OR UPDATE OR DELETE ON emp
  FOR EACH ROW

  BEGIN
    JoursEtHeuresOuvrables;
  END;
/

INSERT INTO emp VALUES('Dark-Sasuke',21831,'administratIF', 16712,'10-SEP-08', 500,NULL, 10);

-- 4)

DROP TABLE historique;

CREATE TABLE historique
  (dateOperation DATE,
  nomUsager VARCHAR2(20),
  typeOperation CHAR
  );

CREATE OR REPLACE TRIGGER trigger_store_operation
  AFTER INSERT OR UPDATE OR DELETE ON emp
  FOR EACH ROW

  BEGIN
    IF inserting THEN
      INSERT INTO historique (dateOperation, nomUsager, typeOperation) VALUES(CURRENT_DATE, :new.NOM, 'I');
    ELSIF deleting THEN
      INSERT INTO historique (dateOperation, nomUsager, typeOperation) VALUES(CURRENT_DATE, :old.NOM, 'D');
    ELSIF updating THEN
      INSERT INTO historique (dateOperation, nomUsager, typeOperation) VALUES(CURRENT_DATE, :new.NOM, 'U');
    END IF;
  END;
/

SELECT *
FROM historique;

INSERT INTO emp VALUES('Dark-Saske', 6666,'administratIF', 16712,'10-SEP-08', 1500, NULL, 10);

UPDATE emp SET nom = 'toto' WHERE num = 6666;

DELETE FROM emp WHERE num = 6666;

SELECT *
FROM historique;

-- 5)

CREATE OR REPLACE TRIGGER dept_cascade
  BEFORE DELETE OR UPDATE OF n_dept ON Dept
  FOR EACH ROW

  BEGIN
    IF deleting THEN
      DELETE FROM emp WHERE n_dept = :old.n_dept;
    ELSIF UPDATING THEN
      UPDATE emp SET n_dept = :new.n_dept WHERE n_dept = :old.n_dept;
    END IF;

  END;
/

UPDATE dept SET n_dept = 11 WHERE n_dept = 10;

ALTER TABLE emp DISABLE CONSTRAINT emp_fkl;

DELETE FROM dept WHERE n_dept = 11;

ROLLBACK;
