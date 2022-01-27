SELECT cod, nombre, COUNT(numpedido) veces
FROM articulo a
LEFT JOIN linped l ON (a.cod=l.articulo)
GROUP BY cod, nombre