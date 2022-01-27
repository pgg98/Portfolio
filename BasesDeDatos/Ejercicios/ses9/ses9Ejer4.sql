create or replace function NumVersiones(pNombre in varchar2) return number is

xVersiones number;
xNombre varchar2(1); 

begin
    select count(*) into xVersiones
    from versiones v
    where nombre=pNombre;
    
    select 'S' into xNombre
    from navegadores
    where nombre=pNombre;
    
    exception
    When no_data_found then
        xVersiones:=-1;
    end;
    
    return xVersiones;
end;