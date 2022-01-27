SELECT nombre, marca, resolucion
FROM camara c, articulo a 
WHERE c.cod=a.cod AND c.cod NOT IN (SELECT articulo
												FROM linped)