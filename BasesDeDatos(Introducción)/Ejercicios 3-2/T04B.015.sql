SELECT nombre,apellidos,YEAR(NOW())-YEAR(nacido) edad
FROM usuario
WHERE email LIKE '%@dlsi.ua.es'
ORDER BY edad desc