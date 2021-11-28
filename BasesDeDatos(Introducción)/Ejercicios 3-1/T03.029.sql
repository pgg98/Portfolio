SELECT nombre
FROM tv t,articulo a
WHERE t.cod=a.cod and pantalla>(SELECT pantalla
											FROM tv
											WHERE cod='A0686')