SELECT distinct articulo
FROM linped l, pedido p
WHERE l.numPedido=p.numPedido AND fecha BETWEEN '2010-02-28' AND '2010-04-01'
ORDER BY articulo asc