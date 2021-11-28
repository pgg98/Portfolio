SELECT v.email,v.nombre,v.apellidos,pp.pagado
FROM VusuAli v
LEFT JOIN
(SELECT usuario,SUM(total) pagado
FROM tiendaonline.pedido p
JOIN Tpedidos t ON p.numPedido=t.numpedido
GROUP BY usuario
) pp
ON pp.usuario=v.email