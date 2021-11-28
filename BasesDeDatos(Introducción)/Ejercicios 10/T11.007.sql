SELECT nombre
FROM articulo
WHERE cod IN (SELECT articulo FROM ptienea)