SELECT usuario, SUM(pvp) total
FROM cesta c, articulo a
WHERE c.articulo=a.cod AND pvp IS NOT null
GROUP BY usuario
ORDER BY total 