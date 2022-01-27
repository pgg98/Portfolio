SELECT marca, COUNT(*) 
FROM articulo
WHERE marca IS not null
GROUP BY marca
HAVING COUNT(*) < 150