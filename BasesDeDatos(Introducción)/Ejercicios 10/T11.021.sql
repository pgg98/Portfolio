SELECT email, nombre
FROM usuario u
WHERE email IN (SELECT usuario FROM pedido)
	AND email IN(
		SELECT usuario
		FROM linped l, pedido p, camara c
		WHERE l.numPedido=p.numPedido AND l.articulo=c.cod)