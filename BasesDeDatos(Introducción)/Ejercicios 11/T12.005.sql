SELECT email,nombre,apellidos,numpedido,pendiente
FROM usuario u,
	(SELECT numpedido,usuario
	FROM pedido
	WHERE numpedido NOT IN (SELECT numpedido FROM linped)
	) pedidos,
	(SELECT usuario,SUM(pvp) pendiente
	FROM cesta c, articulo a 
	WHERE c.articulo=a.cod
	GROUP BY usuario
	) cestas
WHERE email=pedidos.usuario AND email=cestas.usuario