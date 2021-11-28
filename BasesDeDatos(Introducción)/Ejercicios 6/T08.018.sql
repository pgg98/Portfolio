SELECT l.numPedido, nombre, telefono, email
FROM usuario u, pedido p, linped l
WHERE l.numPedido=p.numPedido AND p.usuario=u.email
AND importe=(SELECT MAX(importe) FROM linped WHERE linea=2)