create or replace function ses9_ejer3(pFormato in VARCHAR2) return VARCHAR2 is

aux_descrip recurso.descripcion%TYPE;
xReturn varchar2(100);

begin
    begin
        select descripcion into aux_descrip
        from recurso
        where pFormato=nombre_formato;
        xReturn:=aux_descrip;
        
        exception
            when too_many_rows then
                xReturn:= 'Hay mas de un recurso';
            when no_data_found then
                xReturn:= 'No hay ningun recurso con ese formato';
    end;
    
    return xReturn;
    
end;
        
    
        