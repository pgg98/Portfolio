SELECT a1.cod,a1.nombre,a1.pvp,a2.cod art2,a2.nombre nombre2,a2.pvp pvp2
FROM articulo a1, ptienea pp, articulo a2
WHERE pp.pack=a1.cod AND pp.articulo=a2.cod 