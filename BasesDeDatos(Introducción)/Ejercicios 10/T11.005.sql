SELECT o.cod,a.nombre,a.marca
FROM objetivo o, articulo a
WHERE o.cod=a.cod AND (o.focal='500 mm' OR o.focal='600 mm')
	AND marca NOT IN 
		(SELECT marca
		FROM pedido p, linped l, articulo a
		WHERE p.numpedido=l.numPedido AND l.articulo=a.cod
			AND YEAR(fecha)='2010' AND MONTH(fecha)='11')