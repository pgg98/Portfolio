SELECT pr.codp, pr.nombre, IFNULL(SUM(cantidad),0)
FROM provincia pr
LEFT JOIN usuario u ON (pr.codp=u.provincia)
LEFT JOIN pedido p ON (p.usuario=u.email)
LEFT JOIN linped l ON (p.numPedido=l.numPedido)
GROUP BY pr.codp,pr.nombre