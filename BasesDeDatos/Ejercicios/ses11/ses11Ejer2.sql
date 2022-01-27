create or replace procedure VerPropiedades (pnombre in varchar2) as x_img ORDImage;

begin
    begin
        select imagen into x_img from imagenes where nombre=pnombre;
        DBMS_OUTPUT.PUT_LINE('------------------------------------');
        DBMS_OUTPUT.PUT_LINE('Propiedades de la imagen: ' || pnombre);
        DBMS_OUTPUT.PUT_LINE('------------------------------------');
        DBMS_OUTPUT.PUT_LINE('width       =' || x_img.getWidth());
        DBMS_OUTPUT.PUT_LINE('heigth      =' || x_img.getHeight());
        DBMS_OUTPUT.PUT_LINE('size        =' || x_img.getContentLength());
        DBMS_OUTPUT.PUT_LINE('file type   =' || x_img.getFileFormat());
        DBMS_OUTPUT.PUT_LINE('type        =' || x_img.getContentFormat());
        DBMS_OUTPUT.PUT_LINE('compression =' || x_img.getCompressionFormat());
        DBMS_OUTPUT.PUT_LINE('mime type   =' || x_img.getMimeType());
        DBMS_OUTPUT.PUT_LINE('------------------------------------');
    exception
        when no_data_found then
        DBMS_OUTPUT.PUT_LINE('No existe la imagen: ' || pnombre);
    end;
end;