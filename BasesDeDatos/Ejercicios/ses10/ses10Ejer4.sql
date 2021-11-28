create or replace function FincrementaPrecio(pRecurso in number, pPorcen in number) return number is

xprecio recurso_pago.precio%TYPE;

xReturn number;
begin
    begin
        select precio into xprecio from recurso_pago where codigo=pRecurso;
        exception
            when no_data_found then
                raise_application_error(-20001,'No existe el recurso');
    end;
    xReturn:=xprecio+(xprecio*pPorcen/100);

    return xReturn;
end;