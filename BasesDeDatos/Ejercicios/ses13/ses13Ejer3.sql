create or replace trigger tgr_recurso1 before insert on recurso
for each row

declare
xcontador number:=0;

begin
    select count(*) into xcontador
    from formato f
    where f.nombre=:new.nombre_formato;
    
    if xcontador = 0 then
        insert into formato(nombre,descrip,anyo) values(:new.nombre_formato,
        :new.nombre_formato, null);
    end if;

end;