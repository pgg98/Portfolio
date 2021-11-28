create or replace function NumeroRecursos(pFormato in varchar2) return number is

xnRecursos number;

begin

    select count(*)
    into xnRecursos
    from RECURSO
    where nombre_formato=pFormato;
    
    return xnRecursos;
    
end;

create or replace view V_FORMATO as
select nombre, NumeroRecursos(nombre) as numero
from formato;