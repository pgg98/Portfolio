SELECT u.*,p.*
FROM usuario u
JOIN pedido p ON (p.usuario=u.email)