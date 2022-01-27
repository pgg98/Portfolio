create or replace function sumaVisitas(pNombre in varchar2) return number is

xVisitas number;

existe varchar2(1):='N';

begin
    begin
        select 'S' into existe from portales where pNombre=nombre;
    exception
        when no_data_found then
            xVisitas:=-1;
    end;
    
    if existe='S' then
        select sum(v.num_visitas) into xVisitas
        from visitas v, paginas p
        where p.id_pagina=v.id_pagina and p.nombre_portal=pNombre;
    end if;
    return xVisitas;
end;