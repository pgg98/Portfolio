SELECT dni, nombre, apellidos, email
FROM usuario u, pedido p
WHERE p.usuario=u.email
GROUP BY dni, nombre,  apellidos, email
HAVING COUNT(*) > 1