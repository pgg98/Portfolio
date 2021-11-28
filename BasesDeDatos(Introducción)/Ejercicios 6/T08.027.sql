SELECT linea, numpedido
FROM linped
WHERE cantidad = (SELECT MAX(cantidad) FROM linped)