SELECT l.articulo, a.nombre, a.marca, SUM(cantidad), AVG(importe)
FROM articulo a, linped l
WHERE l.articulo=a.cod
AND articulo IN (SELECT cod FROM camara)
GROUP BY l.articulo, a.nombre, a.marca