ALTER TABLE emp2
ADD CONSTRAINT emp_pk primary key(num);

ALTER TABLE dept2
ADD CONSTRAINT dept_pk primary key (n_dept);

UPDATE emp2 SET n_dept = 10 WHERE n_dept=100;

ALTER TABLE emp2
ADD CONSTRAINT emp_fkl FOREIGN KEY (n_dept) references dept2(n_dept) on delete cascade;

ALTER TABLE emp2
ADD CONSTRAINT emp_fk2 FOREIGN KEY (n_sup) references emp2(num) on delete cascade;

SELECT constraint_name, constraint_type
FROM user_constraints
WHERE table_name IN ('EMP2', 'DEPT2');

1)

CREATE OR REPLACE TRIGGER salary_positive
BEFORE INSERT OR UPDATE OF salaire ON Emp2
FOR EACH ROW
BEGIN
  if :new.salaire < 0 then
      raise_application_error(-20000, 'Nop. Salaire < 0');
  END if;
END;
/

UPDATE Emp2
SET salaire = -42
WHERE num = 24831;

INSERT INTO EMP2 VALUES
	('TOTO',984,'administratif', 16712,'10-SEP-08',-98,NULL,30);

CREATE OR REPLACE TRIGGER salary_smic
BEFORE INSERT OR UPDATE OF salaire ON Emp2
FOR EACH ROW
DECLARE
  n_dept NUMBER;
BEGIN
  SELECT n_dept INTO n_dept FROM DEPT2 WHERE NOM = 'Rennes';

  if :new.salaire < 1000 AND n_dept = :new.n_dept then
      raise_application_error(-20000, 'Nop. Salaire < 1000 sur rennes');
  END if;
END;
/

UPDATE Emp2
SET salaire = -42
WHERE num = 24831;
