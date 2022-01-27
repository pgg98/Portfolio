SELECT distinct pv.*
FROM usuario u,  provincia pv
WHERE u.provincia=codp
ORDER BY pv.nombre