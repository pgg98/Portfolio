SELECT numpedido,fecha,nombre,apellidos
FROM usuario u, pedido p
WHERE p.usuario=u.email AND apellidos LIKE '%martinez%'