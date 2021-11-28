SELECT a.cod,nombre,pvp
FROM articulo a,camara c
WHERE c.cod=a.cod AND tipo LIKE '%compacta%'