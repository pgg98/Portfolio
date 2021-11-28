SELECT a.cod,nombre,pvp,o.*
FROM articulo a
	left JOIN objetivo o ON (o.cod=a.cod)