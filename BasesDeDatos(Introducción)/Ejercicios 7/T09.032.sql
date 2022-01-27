SELECT usuario, SUM(pvp)
FROM cesta c, articulo a
WHERE c.articulo=a.cod
GROUP BY usuario