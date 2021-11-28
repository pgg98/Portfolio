SELECT a.cod,nombre,resolucion, sensor
FROM articulo a
	LEFT JOIN camara c ON (a.cod=c.cod)