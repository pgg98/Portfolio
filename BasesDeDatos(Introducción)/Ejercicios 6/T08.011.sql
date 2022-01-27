SELECT cod,nombre,pvp,c.fecha
FROM articulo a,cesta c
WHERE c.articulo=a.cod AND fecha=(SELECT MAX(fecha) FROM cesta)