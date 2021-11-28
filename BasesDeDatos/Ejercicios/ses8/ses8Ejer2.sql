declare
    i number;
    CURSOR c1 is select * from RECURSO order by descripcion;
    r_aux RECURSO%ROWTYPE;
begin
    i:=0;
    Open c1;
    fetch c1 INTO r_aux;
    while c1%FOUND and i<=2 loop
        if r_aux.nombre_formato='MP3' then
            update recurso set descripcion=upper(descripcion) where codigo=r_aux.codigo;
            i:=i+1;
        end if;
        
        fetch c1 into r_aux;
    END LOOP;
    Close c1;
    commit;
end;