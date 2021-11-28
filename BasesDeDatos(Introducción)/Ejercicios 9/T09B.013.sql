SELECT usuario,SUM(cantidad)
FROM pedido p, linped l,tv t
WHERE p.numPedido=l.numPedido AND l.articulo=t.cod
GROUP BY usuario
HAVING SUM(cantidad)>2