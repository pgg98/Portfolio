SELECT cod, nombre, pvp
FROM articulo, stock
WHERE articulo=cod 
AND disponible=(SELECT MAX(disponible) FROM stock)