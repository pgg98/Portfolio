SELECT p.articulo, a.nombre
FROM articulo a, ptienea p 
WHERE p.articulo=a.cod
UNION ALL
SELECT c.articulo, a.nombre
FROM articulo a, cesta c
WHERE c.articulo=a.cod