SELECT MAX(importe), MIN(importe),avg(importe) 
FROM linped l, articulo a
WHERE a.cod= l.articulo AND a.nombre='Bravia KDL-32EX402'