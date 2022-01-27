SELECT u.nombre, email
FROM usuario u, provincia p
WHERE u.provincia=p.codp AND p.nombre='Asturias'
	AND email NOT IN (SELECT email FROM direnvio)