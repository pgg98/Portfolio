SELECT c.*,nombre,pvp
FROM articulo a
JOIN cesta c ON (c.articulo=a.cod)
WHERE YEAR(fecha)=2010