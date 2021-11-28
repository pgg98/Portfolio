SELECT numpedido,usuario,nombre,apellidos
FROM pedido
	JOIN usuario ON (usuario=email) 