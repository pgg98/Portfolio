SELECT p.numPedido, usuario, COUNT(DISTINCT articulo)
FROM pedido p, linped l
WHERE p.numPedido=l.numPedido
GROUP BY p.numPedido,usuario
HAVING COUNT(DISTINCT articulo)>4