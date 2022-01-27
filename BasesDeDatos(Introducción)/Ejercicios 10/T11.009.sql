SELECT DISTINCT s.articulo
FROM stock s, cesta c, linped l
WHERE s.articulo=c.articulo AND s.articulo=l.articulo