drop table imagenes;

create table IMAGENES (nombre varchar2(50) not null, imagen ORDIMAGE, constraint pk_imagenes primary key
(nombre));

create or replace procedure CARGARIMAGENES as x_imagen ORDImage;

    cursor cursor1 is select nombre, imagen from dbdm_ivan.imagenes_blob;

begin
    for R in cursor1
    loop
        x_imagen:=ordsys.ordimage(ordsys.ordsource(R.imagen, null, null, null, null, 1), null, null, null,
        null,null,null,null);
        x_imagen.setProperties();
        
        insert into IMAGENES(nombre, imagen) values (R.nombre, x_imagen);
    end loop;
    commit;
end;

