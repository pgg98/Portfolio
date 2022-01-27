SELECT distinct a.nombre
FROM articulo a,cesta c, usuario u
WHERE c.articulo=a.cod AND c.usuario=u.email AND u.provincia IN (SELECT codp
																						FROM provincia
																						WHERE nombre LIKE 'Alicante%' OR nombre LIKE 'Valencia%')