SELECT cod, nombre, disponible
FROM articulo a, stock s
WHERE cod=articulo AND entrega='24 horas'
AND disponible=(SELECT MIN(disponible) FROM stock
					 WHERE entrega='24 horas')