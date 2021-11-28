/*create table aud_navegadores
(
    nombre varchar2(50),
    anyo date not null,
    accion varchar2(1),
    constraint chk_aud_navegadores check (accion in ('I','B','M')),
    fecha date default sysdate not null
);*/

create or replace trigger tr_aud_navegadores after insert or update or delete on navegadores
for each row
begin
    if inserting then
        insert into aud_navegadores(nombre,anyo,accion) values(:new.nombre,:new.anyo,'I');
    end if;
    
    if deleting then
        insert into aud_navegadores(nombre,anyo,accion) values(:old.nombre,:old.anyo,'B');
    end if;
    
    if updating then
        insert into aud_navegadores(nombre,anyo,accion) values(:old.nombre,:old.anyo,'M');
    end if;

end;