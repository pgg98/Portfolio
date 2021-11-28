SELECT cod,nombre,a.marca,empresa
FROM articulo a
left JOIN marca m ON (a.marca=m.marca)