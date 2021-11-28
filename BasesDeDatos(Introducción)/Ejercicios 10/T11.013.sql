SELECT DISTINCT u1.apellidos
FROM usuario u1, usuario u2
WHERE u1.email <> u2.email AND u1.apellidos=u2.apellidos