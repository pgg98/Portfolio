SELECT nombre
FROM camara c, articulo a
WHERE c.cod=a.cod AND tipo LIKE '%compacta%visor%electronico%'
UNION 
SELECT nombre
FROM tv t, articulo a
WHERE t.cod=a.cod AND panel LIKE '%televisor%CRT%'