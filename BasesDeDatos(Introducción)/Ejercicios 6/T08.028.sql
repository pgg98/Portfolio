SELECT DISTINCT linea, nombre
FROM articulo a, linped l
WHERE a.cod=l.articulo
AND importe > (SELECT MIN(importe) FROM linped)