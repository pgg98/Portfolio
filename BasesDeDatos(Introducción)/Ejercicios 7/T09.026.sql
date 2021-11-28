SELECT articulo, SUM(cantidad), AVG(importe)
FROM linped
WHERE articulo IN (SELECT cod FROM camara)
GROUP BY articulo