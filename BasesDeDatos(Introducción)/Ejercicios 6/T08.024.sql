SELECT c.cod, nombre, pvp
FROM articulo a, camara c
WHERE c.cod=a.cod AND tipo LIKE '%reflex%'
AND pvp=(SELECT MAX(pvp) FROM articulo a,camara c
			WHERE a.cod=c.cod AND tipo LIKE '%reflex%')