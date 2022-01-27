SELECT numpedido,usuario,apellidos,u.nombre,l.pueblo
FROM pedido p
JOIN usuario u ON (usuario=email)
JOIN localidad l ON (u.pueblo=l.codm AND u.provincia=l.provincia)