SELECT s.*, resolucion
FROM stock s
RIGHT JOIN camara ON (cod=articulo)