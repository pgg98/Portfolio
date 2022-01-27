SELECT usuario
FROM linped l, pedido p
WHERE l.numPedido=p.numPedido
GROUP BY p.numPedido, usuario
HAVING SUM(cantidad*importe)>1000
UNION
SELECT usuario
FROM linped l, pedido p
WHERE l.numPedido=p.numPedido
GROUP BY usuario
HAVING COUNT(DISTINCT articulo)>5