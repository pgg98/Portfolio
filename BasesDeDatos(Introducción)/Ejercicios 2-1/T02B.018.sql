SELECT articulo,nombre,marca,pvp,importe
FROM linped l, articulo a, tv t
WHERE numpedido=1 AND a.cod=l.articulo AND a.cod=t.cod