create or replace procedure Ampliarx2(pnombre in varchar2) as x_img ORDImage;

begin
    begin
        select imagen into x_img from imagenes where nombre=pnombre for update;
        
        x_img.process('scale=2');
        x_img.setProperties();
        update imagenes set imagen=x_img where nombre=pnombre;
        
        exception
            when no_data_found then
                DBMS_OUTPUT.PUT_LINE('No existe la imagen: ' || pnombre);
            when ORDSYS.ORDImageExceptions.DATA_NOT_LOCAL then
                DBMS_OUTPUT.PUT_LINE('La imagen no esta almacenada en la BD sino externamente');
    end;
    commit;
end;