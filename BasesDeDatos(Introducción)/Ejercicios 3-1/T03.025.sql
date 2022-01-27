SELECT nombre
FROM camara c, articulo a
WHERE c.cod=a.cod and marca NOT LIKE 'S%'