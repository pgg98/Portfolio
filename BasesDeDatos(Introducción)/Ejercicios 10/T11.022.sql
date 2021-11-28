SELECT cod,nombre
FROM articulo a
WHERE NOT EXISTS
	(SELECT 1
	FROM pedido p
	WHERE NOT exists
		(SELECT 1
		FROM linped l
		WHERE l.numPedido=p.numPedido
			AND l.articulo=a.cod))