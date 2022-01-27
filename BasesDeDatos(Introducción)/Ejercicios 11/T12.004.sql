SELECT email,nombre,apellidos,numpedido,valor
FROM usuario u
LEFT JOIN 
	(SELECT p.numpedido,usuario,SUM(cantidad*importe) valor
	FROM pedido p, linped l
	WHERE p.numPedido=l.numPedido
	GROUP BY numpedido,usuario
	HAVING SUM(cantidad*importe)>10000) calculo
ON (email=usuario)
WHERE provincia='03'
ORDER BY valor desc