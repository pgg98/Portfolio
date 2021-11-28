create or replace trigger tgr_recurso2 after insert on recurso
for each row

begin
    if :new.nombre_formato='JPG' then
        insert into recurso_gratuito(codigo) values(:new.codigo);
    end if;
    
end;