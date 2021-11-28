create or replace procedure modificaPaginas(pTipo varchar2, pTipoCambio varchar2) is

begin
    if(pTipo is null or pTipoCambio is null) then
        raise_application_error(-20001, 'Codificacion no valida');
    else
        update paginas set codificacion = pTipoCambio where codificacion=pTipo;
    end if;
end;
    
    