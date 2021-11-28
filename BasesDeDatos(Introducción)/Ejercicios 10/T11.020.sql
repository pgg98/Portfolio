SELECT email, nombre
FROM usuario u
WHERE email NOT IN (
	SELECT usuario
	FROM linped l, pedido p, camara c
	WHERE l.numPedido=p.numPedido AND l.articulo=c.cod)