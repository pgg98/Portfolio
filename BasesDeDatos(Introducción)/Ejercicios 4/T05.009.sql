SELECT a.*
FROM articulo a
left JOIN cesta c ON (c.articulo=a.cod AND YEAR(fecha)=2010)
