SELECT fecha,usuario,articulo,nombre,marca,pvp,importe
FROM articulo a, linped l, tv t, pedido p
WHERE l.numPedido=1 AND l.numpedido=p.numpedido AND a.cod=l.articulo AND a.cod=t.cod