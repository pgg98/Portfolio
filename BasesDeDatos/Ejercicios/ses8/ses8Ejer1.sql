declare
    i number;
    CURSOR c1 is select * from RECURSO order by descripcion;
begin
    i:=0;
    
    FOR r_aux IN c1 LOOP
        if r_aux.nombre_formato='MP3' then
            update recurso set descripcion=upper(descripcion) where codigo=r_aux.codigo;
            i:=i+1;
        end if;
        
        if i>=2 then
            exit;
        end if;
    END LOOP;
    commit;
end;