SELECT *
FROM
	(SELECT email,nombre,apellidos,
		(select COUNT(*) FROM pedido WHERE MONTH(fecha)=1 AND YEAR(fecha)=2010 AND usuario=email) enero,
		(select COUNT(*) FROM pedido WHERE MONTH(fecha)=2 AND YEAR(fecha)=2010 AND usuario=email) febrero,
		(select COUNT(*) FROM pedido WHERE MONTH(fecha)=3 AND YEAR(fecha)=2010 AND usuario=email) marzo,
		(select COUNT(*) FROM pedido WHERE MONTH(fecha)=4 AND YEAR(fecha)=2010 AND usuario=email) abril,
		(select COUNT(*) FROM pedido WHERE MONTH(fecha)=5 AND YEAR(fecha)=2010 AND usuario=email) mayo,
		(select COUNT(*) FROM pedido WHERE MONTH(fecha)=6 AND YEAR(fecha)=2010 AND usuario=email) junio,
		(select COUNT(*) FROM pedido WHERE MONTH(fecha)=7 AND YEAR(fecha)=2010 AND usuario=email) julio,
		(select COUNT(*) FROM pedido WHERE MONTH(fecha)=8 AND YEAR(fecha)=2010 AND usuario=email) agosto,
		(select COUNT(*) FROM pedido WHERE MONTH(fecha)=9 AND YEAR(fecha)=2010 AND usuario=email) septiembre,
		(select COUNT(*) FROM pedido WHERE MONTH(fecha)=10 AND YEAR(fecha)=2010 AND usuario=email) octubre,
		(select COUNT(*) FROM pedido WHERE MONTH(fecha)=11 AND YEAR(fecha)=2010 AND usuario=email) noviembre,
		(select COUNT(*) FROM pedido WHERE MONTH(fecha)=12 AND YEAR(fecha)=2010 AND usuario=email) diciembre
		FROM usuario) pormeses
WHERE enero+febrero+marzo+abril+mayo+junio+julio+agosto+septiembre+octubre+noviembre+diciembre > 1