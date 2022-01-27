SELECT m.marca,COUNT(a.marca)
FROM marca m
LEFT JOIN articulo a ON m.marca=a.marca
GROUP BY marca
HAVING COUNT(a.marca)<150