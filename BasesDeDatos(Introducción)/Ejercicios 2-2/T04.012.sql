SELECT DISTINCT articulo
FROM pedido p, linped l
WHERE l.numPedido=p.numPedido AND year(fecha)='2010'
ORDER BY articulo asc