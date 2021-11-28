SELECT c.articulo,c.usuario,c.fecha,s.articulo stock,s.disponible,s.entrega
FROM cesta c,stock s
WHERE c.articulo=s.articulo AND entrega='descatalogado'