SET SERVEROUTPUT ON;

DECLARE
total number:=0;
BEGIN
select count(*) into total
from recurso; 
if total>5 then dbms_output.put_line('Hay mas de 5 recursos');
else dbms_output.put_line('Hay 5 o menos recursos');
end if; 
END;