SELECT codp,nombre,COUNT(*)
FROM provincia p, localidad l
WHERE l.provincia=p.codp
GROUP BY codp,nombre
HAVING COUNT(*)>100