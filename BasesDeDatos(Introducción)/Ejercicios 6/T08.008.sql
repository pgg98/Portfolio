SELECT nombre,pvp
FROM articulo,stock
WHERE cod=articulo AND disponible = (SELECT MIN(disponible) 
												 FROM stock)