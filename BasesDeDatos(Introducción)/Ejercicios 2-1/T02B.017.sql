SELECT articulo,nombre,marca,pvp,importe
FROM articulo a,linped l
WHERE numpedido=1 AND a.cod=l.articulo