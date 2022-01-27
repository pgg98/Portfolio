SELECT cod,nombre,pvp-importe
FROM articulo a, linped l
WHERE cod=articulo AND pvp<>importe 