SELECT c.articulo, COUNT(*)
FROM cesta c,stock s
WHERE c.articulo=s.articulo AND disponible=0
GROUP BY c.articulo