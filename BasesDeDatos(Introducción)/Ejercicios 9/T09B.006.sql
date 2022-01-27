SELECT p.numPedido, p.usuario
FROM pedido p,linped l
WHERE p.numPedido=l.numPedido
GROUP BY p.numPedido, p.usuario
HAVING SUM(cantidad*importe)>4000