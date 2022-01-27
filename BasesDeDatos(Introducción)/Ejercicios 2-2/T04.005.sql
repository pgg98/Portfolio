SELECT *
FROM pedido
WHERE (fecha = '2010-03-03' OR fecha = '2010-10-27') AND usuario LIKE '%@cazurren.%';