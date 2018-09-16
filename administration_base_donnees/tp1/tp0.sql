rlwrap sqlplus $username/$mdp@venus/master

start ScriptCreation.sql

SET serveroutput ON size 30000;

CREATE OR REPLACE TRIGGER T1
  BEFORE INSERT OR DELETE ON emp
  FOR EACH ROW
  BEGIN
    dbms_output.put_line('Yolo.');
  END;
  /

SELECT *
FROM emp;

desc user_triggers;

-- show error

SELECT trigger_name FROM user_triggers;

INSERT INTO emp(nom, num, salaire)
VALUES ('jean-kevin',  9999, 1789);

CREATE OR REPLACE TRIGGER T1
  BEFORE INSERT ON emp
  FOR EACH ROW
  BEGIN
    raise_application_error(-20099, 'Nop.');
  END;
  /

INSERT INTO emp(nom, num, salaire)
VALUES ('jean-kevin',  9999, 1789);

SELECT text
FROM user_source
WHERE name = 'T1';

CREATE OR REPLACE TRIGGER T1
  BEFORE INSERT OR DELETE ON emp
  FOR EACH ROW
  BEGIN
    dbms_output.put_line('GG : '||:new.num);
  END;
  /

INSERT INTO emp(nom, num, salaire)
VALUES ('jean-kevin',  9999, 1789);

CREATE OR REPLACE TRIGGER T1
BEFORE INSERT OR DELETE OR UPDATE ON emp
FOR EACH ROW
BEGIN
  IF INSERTING then
    dbms_output.put_line('ADD : ' ||:new.num);
  ELSIF DELETING then
    dbms_output.put_line('DELETE : ' ||:old.num);
  ELSIF UPDATING then
    dbms_output.put_line('UPDATE : '||:new.num||' -> ' ||:new.num);
  END IF;
END;
/

INSERT INTO emp(nom, num, salaire)
VALUES ('jean-kevin',  9999, 1789);

DELETE FROM emp
WHERE nom = 'jean-kevin';

UPDATE emp
SET num = 9998
WHERE nom = 'jean-kevin';
