SELECT numpedido,usuario,DATE_FORMAT(fecha,'%d/%m/%Y') cuando
FROM pedido
WHERE DATE_FORMAT=(fecha,'%u')=DATE_FORMAT('2010-11-07','%u')