create or replace trigger tr_bor_navegadores before delete on navegadores
for each row
begin
    delete suministran where nombre=:old.nombre;
    delete tienen where nombre=:old.nombre;
    delete disponible_para where nombre=:old.nombre;
    delete versiones where nombre=:old.nombre;
end;