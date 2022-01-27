create table categoria_portales
(nombre varchar2(50),
categoria VARCHAR2(15),
constraint pk_categoria_porta primary key (nombre));

declare
    cursor c1 is select * from portales;
    nporta integer;
    wcat varchar2(15);
    rpo PORTALES%ROWTYPE;
begin
    open c1;
    fetch c1 into rpo;
    if c1%notfound then
        raise_application_error(-20001, 'Tabla PORTALES vacía');
    else
        while c1%found loop
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
            fetch c1 into rpo;
        end loop;
        close c1;
        commit;
    end if;
END;