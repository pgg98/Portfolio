SELECT t.cod,nombre
FROM tv t, articulo a
WHERE t.cod=a.cod AND panel LIKE '%LED%' AND pvp<=1000