SELECT DISTINCT c.usuario,DATEDIFF(c.fecha,p.fecha) dias
FROM pedido p,cesta c
WHERE p.usuario=c.usuario 