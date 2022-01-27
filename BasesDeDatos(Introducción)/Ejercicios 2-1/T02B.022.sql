SELECT cod,sensor,pantalla
FROM camara
WHERE pantalla IS NOT null
ORDER BY cod desc