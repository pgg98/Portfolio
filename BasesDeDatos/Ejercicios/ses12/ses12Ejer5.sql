create or replace function DimeMimeType(pNombre in varchar2) return varchar2 as x_img ORDImage;
begin
    begin
        select imagen into x_img
        from imagenes
        where nombre=pNombre;
    
        return x_img.getMimeType;
    
        exception
            when no_data_found then
                return 'XX';
    end;
end;

/*create or replace view v_MimeTypes as
    select DimeMimeType(nombre) as Mime, count(*) as cantidad
    from imagenes
    group by DimeMimeType(nombre);*/