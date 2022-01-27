create or replace trigger tgr_recurso3 before insert or update of falta on recurso
for each row

when(new.falta < to_date('01/01/2010','dd/mm/yyyy'))
begin
    :new.descripcion:=upper(:new.descripcion);
end;