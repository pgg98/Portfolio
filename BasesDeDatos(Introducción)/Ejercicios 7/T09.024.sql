SELECT articulo, SUM(cantidad)
FROM linped
GROUP BY articulo