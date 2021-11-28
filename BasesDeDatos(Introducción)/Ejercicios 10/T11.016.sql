SELECT email, nombre, apellidos
FROM usuario u
WHERE email IN 
	(SELECT usuario FROM pedido p, linped l, tv t
	WHERE p.numPedido=l.numPedido AND l.articulo=t.cod)
	AND email NOT IN (
	SELECT usuario FROM pedido p, linped l, camara c
	WHERE p.numPedido=l.numPedido AND l.articulo=c.cod)