SELECT DISTINCT p.nombre
FROM provincia p,usuario u,pedido pe
WHERE u.provincia=p.codp AND pe.usuario=u.email