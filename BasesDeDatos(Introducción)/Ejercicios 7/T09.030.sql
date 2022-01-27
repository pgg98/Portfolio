SELECT articulo, COUNT(DISTINCT numpedido)
FROM linped
WHERE articulo IN ('A0233','A1085')
GROUP BY articulo