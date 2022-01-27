SELECT SUM(cantidad) cantidadTotal
FROM articulo, linped
WHERE articulo=cod and nombre LIKE 'UE22%'