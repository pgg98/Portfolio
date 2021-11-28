SELECT nombre, pvp, marca
FROM articulo a, stock s
WHERE a.cod=s.articulo
AND s.disponible = (SELECT MAX(disponible) FROM stock)