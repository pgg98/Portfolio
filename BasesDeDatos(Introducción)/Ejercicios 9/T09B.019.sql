SELECT cod, nombre
FROM articulo a
WHERE cod IN(SELECT articulo
				 FROM pedido p, linped l
				 WHERE usuario='acm@colegas.com' AND p.numPedido=l.numPedido
				 GROUP BY articulo
				 HAVING COUNT(DISTINCT p.numPedido) = 
				 			(SELECT COUNT(*) FROM pedido WHERE usuario='acm@colegas.com')
		)