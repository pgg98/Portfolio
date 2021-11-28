create or replace function NMismoFormato(pCodigo in number) return number is

xReturn number;

xnombre_formato RECURSO.NOMBRE_FORMATO%type;

begin
    begin 
        select nombre_formato into xnombre_formato
        from recurso
        where codigo=pCodigo;
        
        exception
            when no_data_found then
                xReturn:=-1;
    end;
        
    if xReturn <> -1 then
        select count(*) into xReturn
        from recurso
        where nombre_formato=xnombre_formato;
    end if;
    
    return xReturn;
    
end;
        