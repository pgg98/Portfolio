SELECT numpedido,COUNT(*)
FROM linped
WHERE cantidad >=3
GROUP BY numpedido