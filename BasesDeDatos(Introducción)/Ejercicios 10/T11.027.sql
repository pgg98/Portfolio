SELECT distinct *
FROM pedido p
WHERE numpedido IN (SELECT numpedido FROM linped l,camara c
							WHERE l.articulo=c.cod)
	AND numpedido IN (SELECT numpedido FROM linped l,objetivo o 
				          WHERE l.articulo=o.cod)