SELECT distinct numPedido
FROM articulo a,linped l
WHERE l.articulo=a.cod AND importe<pvp