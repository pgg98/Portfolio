SELECT COUNT(*)
FROM articulo
WHERE cod NOT IN (SELECT cod FROM camara)
AND cod NOT IN (SELECT cod FROM tv)
AND cod NOT IN (SELECT cod FROM memoria)
AND cod NOT IN (SELECT cod FROM objetivo)
AND cod NOT IN (SELECT cod FROM pack)
