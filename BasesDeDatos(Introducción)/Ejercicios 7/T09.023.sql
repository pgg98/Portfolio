SELECT l.numPedido, COUNT(*)
FROM linped l, pedido p
WHERE l.numPedido=p.numPedido AND fecha<'2010-09-01'
GROUP BY numPedido