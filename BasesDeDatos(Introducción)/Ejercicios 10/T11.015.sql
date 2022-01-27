SELECT cod, nombre
FROM articulo
WHERE cod IN (
	SELECT articulo
	FROM stock
	where entrega='Descatalogado'
	UNION
	SELECT cod
	FROM articulo
	WHERE cod NOT IN (SELECT articulo FROM linped))