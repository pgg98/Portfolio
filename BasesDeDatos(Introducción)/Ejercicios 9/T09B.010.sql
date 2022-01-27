SELECT pueblo, COUNT(*)
FROM localidad
GROUP BY pueblo
HAVING COUNT(*)>1