SELECT MAX(pvp)
FROM articulo, stock
WHERE cod=articulo AND entrega='Próximamente'