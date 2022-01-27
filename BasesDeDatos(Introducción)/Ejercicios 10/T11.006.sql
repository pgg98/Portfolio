SELECT cod, pvp
FROM articulo a
WHERE marca LIKE 'Samsung' AND pvp IS NOT NULL AND 
	a.cod NOT IN (SELECT articulo FROM linped) 