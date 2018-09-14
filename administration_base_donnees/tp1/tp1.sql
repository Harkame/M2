ALTER TABLE emp3
ADD CONSTRAINT emp3_pk primary key(num);

ALTER TABLE dept3
ADD CONSTRAINT dept3_pk primary key (n_dept);

UPDATE emp3 SET n_dept = 10 WHERE n_dept=100;

ALTER TABLE emp3
ADD CONSTRAINT emp3_fkl FOREIGN KEY (n_dept) references dept3(n_dept) on delete cascade;

ALTER TABLE emp3
ADD CONSTRAINT emp3_fk2 FOREIGN KEY (n_sup) references emp3(num) on delete cascade;

SELECT constraint_name, constraint_type
FROM user_constraintsALTER TABLE emp3
ADD CONSTRAINT emp_pk primary key(num);

ALTER TABLE dept3
ADD CONSTRAINT dept_pk primary key (n_dept);

UPDATE emp3 SET n_dept = 10 WHERE n_dept=100;

ALTER TABLE emp3
ADD CONSTRAINT emp_fkl FOREIGN KEY (n_dept) references dept3(n_dept) on delete cascade;

ALTER TABLE emp3
WHERE table_name IN ('emp3', 'dept3');

1)

CREATE OR REPLACE TRIGGER salary_positive
BEFORE INSERT OR UPDATE OF salaire ON emp3
FOR EACH ROW
BEGIN
  if :new.salaire < 0 then
      raise_application_error(-20000, 'Nop. Salaire < 0');
  END if;
END;
/

UPDATE emp3
SET salaire = -42
WHERE num = 24831;

INSERT INTO emp3 VALUES
	('TOTO',984,'administratif', 16712,'10-SEP-08',-98,NULL,30);

CREATE OR REPLACE TRIGGER salary_smic
BEFORE INSERT OR UPDATE OF salaire ON emp3
FOR EACH ROW

DECLARE
  CURSOR citys IS SELECT * FROM dept3 WHERE NOM = 'Rennes';

BEGIN
  dbms_output.put_line('NOUVEAU SALAIRE : '||:new.salaire);

  for city IN citys LOOP
    if :new.salaire < 1000 AND city.n_dept = :new.n_dept then
      raise_application_error(-20000, 'Nop. Salaire < 1000 sur rennes');
    END if;
  END loop;
END;
/

CREATE OR REPLACE TRIGGER salary_smic
BEFORE INSERT OR UPDATE OF salaire ON emp3
FOR EACH ROW

DECLARE
lieu_dept dept3.lieu%type;

BEGIN
  dbms_output.put_line('n_dept : ' ||:new.salaire);


  SELECT lieu INTO lieu_dept
  FROM dept3
  WHERE :new.n_dept;

  if :new.salaire < 1000 AND lieu_dept = 'Rennes' then
    raise_application_error(-20000, 'Nop. Salaire < 1000 sur rennes');
  END if;
END;
/

INSERT INTO EMP3 VALUES('Dark-Sasuke',21831,'administratif', 16712,'10-SEP-08', 500,NULL, 10);
