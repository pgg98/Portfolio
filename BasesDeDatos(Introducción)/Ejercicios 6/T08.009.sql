SELECT p.numPedido, fecha, nombre, apellidos
FROM usuario u, pedido p, linped l
WHERE p.usuario=u.email AND l.numPedido=p.numPedido 
AND (cantidad*importe)=(SELECT MAX(cantidad*importe) FROM linped)