SELECT DISTINCT l.pueblo
FROM usuario u, localidad l
WHERE u.pueblo=l.codm AND u.provincia=l.provincia 
AND email IN (SELECT usuario
					FROM pedido p
					GROUP BY usuario
					HAVING COUNT(*)>=2)