SELECT p.numPedido, p.usuario, SUM(cantidad)
FROM pedido p, linped l
WHERE l.numPedido=p.numPedido 
GROUP BY p.numPedido,p.usuario
HAVING SUM(cantidad)>10