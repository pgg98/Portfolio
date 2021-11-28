SELECT apellidos,nombre,numpedido
FROM usuario 
	left JOIN pedido ON (email=usuario)