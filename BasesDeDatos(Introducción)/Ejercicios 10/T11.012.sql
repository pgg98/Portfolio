SELECT email, nombre
FROM usuario
WHERE email NOT IN (SELECT usuario FROM pedido)
UNION
SELECT email, nombre
FROM usuario, pedido
WHERE usuario=email
GROUP BY email, nombre
HAVING COUNT(*)=1