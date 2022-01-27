SELECT numpedido, articulo
FROM linped
WHERE importe=(SELECT MIN(importe) FROM linped)