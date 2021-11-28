SELECT numpedido,DATE_FORMAT(Fecha,'%d.%c.%Y') Fecha
FROM pedido
WHERE fecha=STR_TO_DATE('13.9.2010','%d.%c.%Y')