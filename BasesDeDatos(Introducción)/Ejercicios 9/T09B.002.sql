SELECT marca, COUNT(*) 
FROM articulo
GROUP BY marca
HAVING COUNT(*) < 150