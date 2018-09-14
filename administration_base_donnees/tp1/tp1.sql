rlwrap sqlplus $username/$mdp@venus/master

start ScriptCreation.sql

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
