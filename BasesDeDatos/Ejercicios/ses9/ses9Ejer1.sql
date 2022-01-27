create or replace procedure InsertaRecurso(pCodigo in number, pDescripcion in VARCHAR2, pFormato in VARCHAR2,
pTipo in VARCHAR2,pPrecio in number) is 

begin
    begin
        insert into recurso(codigo,descripcion,falta,nombre_formato) values(pCodigo,pDescripcion,sysdate,pFormato);
        excepcion
            when dup_val_on_index then
                raise_application_error(-20001, 'El recurso ya existe');
        end;
        
        if pTipo='PAGO' then
            insert into recurso_pago(codigo, precio) values (pCodigo, pPrecio);
        else
            insert into recurso_gratuito(codigo) values (pCodigo);
        end if;
        
end;