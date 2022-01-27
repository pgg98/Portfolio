create or replace procedure cambiarformato(pMaximo in number) is

cursor c1 is select nombre, imagen from imagenes for update;

begin
    for r in c1 loop
        if r.imagen.getContentLength()>pMaximo and r.imagen.getFileFormat()<>'PNGF' then
            r.imagen.process('fileFormat=PNGF');
            r.imagen.process('scale="2"');
            r.imagen.setProperties;
            
            update imagenes set imagen=r.imagen where nombre=r.nombre;
            dbms_output.put_line ('cambiada la imagen '||r.nombre||' a PNG');
        end if;
    end loop;
    commit;
end;
        