SELECT v$session.username,  process, v$session.terminal, to_char(logon_time, 'YYYY-MM-DD HH24:MI') as logon_time
FROM v$session, v$process
WHERE type='USER'
AND v$session.paddr = v$process.addr;

CREATE OR REPLACE PROCEDURE locker AS
  cursor C IS SELECT l.sid, username FROM v$lock l, v$session s WHERE block = 1 AND l.sid = s.sid;
  BEGIN
  FOR c_t IN c LOOP
    dbms_output.put_line('Locker : '||c_t.sid||'  '||c_t.username);
  END LOOP;
END;
/

2.3.7



2.3.8
1) READ ONLY :
2) SERIALIZABLE : Previent les ecritures sur les donnes

Lecture repetable : ???

COMMITED : Ne previent pas les repetables
