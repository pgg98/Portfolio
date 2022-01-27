SELECT articulo, SUM(cantidad), AVG(importe)
FROM linped
GROUP BY articulo