SELECT nombre,COUNT(*)
FROM provincia
GROUP BY nombre
HAVING COUNT(*)>1