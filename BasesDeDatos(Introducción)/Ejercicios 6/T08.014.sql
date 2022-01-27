SELECT nombre, cod, disponible MinDisponible
FROM articulo, stock
WHERE articulo=cod AND cod LIKE '%3'
AND disponible=(SELECT MIN(disponible) FROM stock)