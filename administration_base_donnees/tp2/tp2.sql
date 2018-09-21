CREATE OR REPLACE PROCEDURE P1(dep in integer, nomDept out varchar)
  IS
  BEGIN
    SELECT nom INTO nomDept FROM dept WHERE n_dept = dep;
  END;
  /

SET serveroutput on;

DECLARE
name dept.nom%type;
BEGIN
p1(10, name);
  dbms_output.put_line('le nom est ' || name);
end;
/

CREATE OR REPLACE FUNCTION f1 (dep in integer) return varchar
IS
nomD dept.nom%type;
BEGIN
  SELECT nom into nomD FROM dept WHERE n_dept = dep;
  return nomD;
END;
/

DECLARE
name dept.nom%type;
BEGIN
name := f1(10);
dbms_output.put_line('le nom est ' || name);
end;
/

DROP TABLE connexions;

CREATE TABLE connexions
  (c_user VARCHAR2(20),
  os_user VARCHAR2(20),
  c_date date,
  ipAddress VARCHAR2(20),
  terminal VARCHAR2(20),
  hote VARCHAR2(20)
  );

SELECT sys_context('USERENV', 'IP_ADDRESS') FROM dual;

CREATE OR REPLACE TRIGGER logon_db AFTER logon ON DATABASE
DECLARE

t_user connexions.c_user%type
t_os_user connexions.os_yser%type,
t_date connexions.c_date%type,
t_ip_address connexions.ipAddress%type,
t_terminal connexions.terminal%type,
t_hote connexions.hote%type

  BEGIN
    SELECT sys_context('USERENV', 'OS_USER'), sys_context('USERENV', 'IP_ADDRESS') INTO t_user, t_ip_address FROM DUAL

    INSERT INTO connexions VALUES (user, o_user, sysdate, t_ip_address, '', '');

    COMMIT;
  END;

SELECT * FROM connexion WHERE usager not in ('SYS', 'SYSTEM');

CREATE OR REPLACE PROCEDURE DepartmentWorker(department_id IN integer, list_worker OUT VARCHAR2) IS
  cursor departments IS SELECT * FROM emp WHERE n_dept = department_id;
  no_worker exception;

  BEGIN
    FOR department IN departments LOOP
      list_worker := list_worker||' '||department.num||' '||department.nom||' '||department.fonction;
    END LOOP;

    IF list_worker IS NULL THEN
      RAISE no_worker;
    END IF;

    EXCEPTION
      WHEN no_worker THEN list_worker := 'Department not found';
      WHEN others THEN list_worker := 'Error';
  END;

CREATE OR REPLACE PROCEDURE foo(department_id IN INTEGER) IS
listWorker VARCHAR2(1000);
BEGIN
  DepartmentWorker(department_id, listWorker);
  dbms_output.put_line('Workers :'||department_id||' : '||listWorker);
END;
