SELECT numpedido,usuario,apellidos,u.nombre,l.pueblo,p.nombre
FROM usuario u
JOIN pedido ON (usuario=email)
JOIN localidad l ON (u.pueblo=l.codm AND u.provincia=l.provincia)
JOIN provincia p ON (l.provincia=codp)