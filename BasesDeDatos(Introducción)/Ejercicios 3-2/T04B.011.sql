SELECT numpedido,DATE_FORMAT(fecha,'%d.%m.%y') Fecha,usuario
FROM pedido 
ORDER BY fecha DESC,usuario asc