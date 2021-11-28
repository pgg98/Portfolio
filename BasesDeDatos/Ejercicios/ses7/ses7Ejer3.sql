SET SERVEROUTPUT ON;

declare
max_codigo number;

begin

    begin
    insert into recurso (codigo, descripcion, nombre_formato) values (1,'recurso x','MP3'); 
    
    exception
    when dup_val_on_index then 
    select max(codigo)+1 into max_codigo from recurso;
    insert into recurso (codigo, descripcion, nombre_formato) values(max_codigo,'recurso x','MP3'); 
    end;
    
end;