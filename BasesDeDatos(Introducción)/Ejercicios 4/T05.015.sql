SELECT cod,nombre,pack
FROM articulo 
LEFT JOIN ptienea ON (cod=articulo)