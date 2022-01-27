SELECT apellidos,nombre,COUNT(*)
FROM usuario
WHERE apellidos LIKE 'Martinez%'
GROUP BY apellidos,nombre