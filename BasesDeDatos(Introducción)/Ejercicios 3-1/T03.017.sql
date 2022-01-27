SELECT c.cod,nombre,tipo,marca
FROM camara c, articulo a
WHERE c.cod=a.cod AND marca IN ('NIKON','LG','SIGMA')