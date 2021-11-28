create or replace procedure numVisitas(pPortal varchar2) is

cursor c1 is
    select to_char(fecha_visita, 'dd/mm/yyyy') as fecha, sum(num_visitas) as num_visitas
    from visitas v, paginas p
    where p.id_pagina=v.id_pagina and p.nombre_portal=pPortal
    group by to_char(fecha_visita, 'dd/mm/yyyy');

begin
    for rC in c1 loop
        if rC.num_visitas < 5 then
            dbms_output.put_line('El portal '||pPortal||' ha tenido un numero BAJO de vistas el dia '||rC.fecha);
        else
            dbms_output.put_line('El portal '||pPortal||' ha tenido un numero ALTO de vistas el dia '||rC.fecha);
        end if;
    end loop;
end;