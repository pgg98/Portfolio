create or replace procedure actualizaPrecios(pFormato in VARCHAR2, pPorcentaje in number) is

cursor c1 is
select r.codigo
from recurso_pago p, recurso r
where p.precio>15 and nombre_formato=pFormato and p.codigo=r.codigo;

xpreciofinal number;

begin
    for r_aux in c1 loop
        incrementaPrecio(r_aux.codigo,pPorcentaje,xpreciofinal);
        if xpreciofinal>100 then
            update recurso_pago set precio=100 where codigo=r_aux.codigo;
        end if;
    end loop;
    commit;
end;
        