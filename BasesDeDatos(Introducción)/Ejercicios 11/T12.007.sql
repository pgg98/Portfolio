SELECT provincia,COUNT(*) pedidos
FROM usuario u,
	(SELECT usuario,p.numPedido,SUM(importe*cantidad) total 
	FROM pedido p
	JOIN linped l ON (p.numpedido=l.numPedido)
	GROUP BY usuario,numpedido) pd
WHERE u.email=pd.usuario
GROUP BY provincia
HAVING AVG(total)>2500