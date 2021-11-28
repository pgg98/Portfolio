SELECT a.cod, nombre, resolucion
FROM tv t,articulo a
WHERE t.cod=a.cod AND pantalla NOT BETWEEN 22 AND 42