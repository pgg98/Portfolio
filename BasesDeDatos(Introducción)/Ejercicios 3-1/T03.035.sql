SELECT distinct nombre
FROM articulo a, cesta c
WHERE c.articulo=a.cod AND c.fecha BETWEEN '2010-11-01' AND '2010-12-31'