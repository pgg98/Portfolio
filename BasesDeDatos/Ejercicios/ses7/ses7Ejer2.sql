SET SERVEROUTPUT ON;

declare

rec_pago number:=0;
rec_gratis number:=0;

begin

select count(*) into rec_pago
from recurso_pago;

select count(*) into rec_gratis
from recurso_gratuito;

if rec_gratis>=rec_pago then raise_application_error(-20001, 'ERROR-> Hay demasiados recursos gratuitos');
end if;

end;