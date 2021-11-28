CREATE OR REPLACE VIEW TApedidos AS
SELECT p.numPedido, SUM(importe*cantidad) total,DATE(fecha),usuario
FROM tiendaonline.pedido p, tiendaonline.linped l
WHERE p.numPedido=l.numPedido AND usuario IN
	(SELECT email FROM tiendaonline.usuario
	WHERE provincia='03')
GROUP BY p.numPedido,DATE(fecha),usuario
