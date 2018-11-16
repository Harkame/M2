
create or replace procedure remplissage (compteur number) is
i number;
comme char(97);
begin
comme := 'cot_';
for i in 0 .. compteur
loop
comme := dbms_random.value || i ;
insert into test values (i,comme);
end loop;
end;
/

exec remplissage(999)