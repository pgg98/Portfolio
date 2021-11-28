SELECT distinct marca
FROM marca
WHERE marca NOT IN (SELECT marca
							FROM articulo a, tv t
							WHERE a.cod=t.cod)