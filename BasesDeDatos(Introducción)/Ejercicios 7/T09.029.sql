SELECT MONTH(fecha) mes, YEAR(fecha) año, COUNT(*)
FROM pedido
GROUP BY MONTH(fecha), YEAR(fecha)