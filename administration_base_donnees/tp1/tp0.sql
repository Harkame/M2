rlwrap sqlplus $username/$mdp@venus/master

start ScriptCreation.sql

SET serveroutput ON size 30000;

CREATE OR REPLACE TRIGGER T1
BEFORE INSERT OR DELETE ON Emp
FOR EACH ROW
BEGIN
  dbms_output.put_line('Yolo.');
END;
/

SELECT *
FROM Emp;

desc user_triggers;

-- show error

SELECT trigger_name FROM user_triggers;

INSERT INTO Emp(nom, num, salaire)
VALUES ('jean-kevin',  9999, 1789);

CREATE OR REPLACE TRIGGER T1
BEFORE INSERT ON Emp
FOR EACH ROW
BEGIN
  raise_application_error(-20099, 'Nop.');
END;
/

INSERT INTO Emp(nom, num, salaire)
VALUES ('jean-kevin',  9999, 1789);

SELECT text
FROM user_source
WHERE name = 'T1';

CREATE OR REPLACE TRIGGER T1
BEFORE INSERT OR DELETE ON Emp
FOR EACH ROW
BEGIN
  dbms_output.put_line('GG : '||:new.num);
END;
/

INSERT INTO Emp(nom, num, salaire)
VALUES ('jean-kevin',  9999, 1789);

CREATE OR REPLACE TRIGGER T1
BEFORE INSERT OR DELETE OR UPDATE ON Emp
FOR EACH ROW
BEGIN
  if inserting then
    dbms_output.put_line('ADD : ' ||:new.num);
  elsif deleting then
    dbms_output.put_line('DELETE : ' ||:old.num);
  elsif updating then
    dbms_output.put_line('UPDATE : '||:new.num||' -> ' ||:new.num);
  END if;
END;
/

INSERT INTO Emp(nom, num, salaire)
VALUES ('jean-kevin',  9999, 1789);

DELETE FROM Emp
WHERE nom = 'jean-kevin';

UPDATE Emp
SET num = 9998
WHERE nom = 'jean-kevin';
