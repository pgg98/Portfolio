SELECT a.cod
FROM articulo a
WHERE marca = 'Samsung' AND cod IN 
	(SELECT articulo FROM linped) 