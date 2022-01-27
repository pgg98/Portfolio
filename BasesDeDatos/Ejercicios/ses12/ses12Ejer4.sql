drop table imagenes;

create table imagenes(nombre varchar2(50) not null, imagen ORDImage, constraint pk_imagenes 
primary key (nombre)); 

declare
    x_imagen ORDImage;
    cursor c1 is select nombre; imagen from dbdm_ivan.imagenes_blob;
    
begin
    for R in c1 loop
        x_imagen:=ordsys.ordimage(ordsys.ordsource(R.imagen, null, null, null, null,1),
        null,null,null,null,null,null,null);
        
        x_imagen.setProperties();
        
        insert into imagenes(nombre,imagen) values(R.nombre, x_imagen);
    end loop;
    commit;
end;