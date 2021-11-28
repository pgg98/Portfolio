SELECT email, nombre, apellidos, ' GRAN CLIENTE '
FROM usuario u, linped l, pedido p
WHERE l.numPedido=p.numPedido AND p.usuario=u.email
GROUP BY email, nombre, apellidos
HAVING SUM(cantidad*importe)>10000
UNION
SELECT email, nombre, apellidos, ' CLIENTE MEDIO '
FROM usuario u, linped l, pedido p
WHERE l.numPedido=p.numPedido AND p.usuario=u.email
GROUP BY email, nombre, apellidos
HAVING SUM(cantidad*importe) BETWEEN 6000 AND 10000
UNION
SELECT email, nombre, apellidos, ' COMPRA POCO '
FROM usuario u, linped l, pedido p
WHERE l.numPedido=p.numPedido AND p.usuario=u.email
GROUP BY email, nombre, apellidos
HAVING SUM(cantidad*importe)<6000
UNION
SELECT email, nombre, apellidos, '** NO HA COMPRADO NUNCA'
FROM usuario 
WHERE email NOT IN (SELECT usuario FROM pedido)
ORDER BY 3;
