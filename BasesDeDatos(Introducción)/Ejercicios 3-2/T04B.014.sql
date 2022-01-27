SELECT articulo, DATE_FORMAT(fecha,'%u') semana,YEAR(fecha) año
FROM linped l, pedido p
WHERE l.numPedido=p.numPedido AND month(fecha)=9 AND YEAR(fecha)=2010
ORDER BY semana
