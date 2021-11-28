create or replace procedure Inserta_acceso(pCodigo in number, pMes in varchar2) is 

cursor c1 is
    select identificador from usuarios;
    
begin
    for r_aux in c1 loop
        begin
            insert into control_acceso(id_usuario,cod_recurso,mes) values(r_aux.identificador,
            pCodigo, pMes);
    
        exception
            when Others then
                RAISE_APPLICATION_ERROR (-20001,'Error en la inserción');
                
            when dup_val_on_index then
                dbms_output.put_line ('Obviando la inserción para el usuario '|| r_aux.identificador);
        end;
    end loop;
end;
        