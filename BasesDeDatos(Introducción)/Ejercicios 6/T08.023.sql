SELECT cod, nombre, marca
FROM articulo
WHERE pvp=(SELECT MAX(pvp) FROM articulo)