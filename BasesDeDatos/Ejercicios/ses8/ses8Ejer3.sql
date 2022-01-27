create table categoria_portales
(nombre varchar2(50),
categoria VARCHAR2(15),
constraint pk_categoria_porta primary key (nombre));

declare
    cursor c1 is select * from portales;
    nporta integer;
    wcat varchar2(15);
begin
    select count(*) into nporta from portales;
    if nporta=0 then
        raise_application_error(-20001, 'Tabla PORTALES vacía');
    end if;
    for rpo in c1 loop
        if rpo.num_usu is null then
            wcat:='sin datos';
        elsif rpo.num_usu>=1 and rpo.num_usu<51 then
            wcat:='pequeño';
        elsif rpo.num_usu>=51 and rpo.num_usu<100 then 
            wcat:='mediano';
        else
            wcat:='grande';
        end if;
        insert into categoria_portales(nombre,categoria) values(rpo.nombre, wcat);
    end loop;
    commit;
END;