SELECT u.nombre,l.pueblo,p.nombre
FROM usuario u, localidad l, provincia p
WHERE u.pueblo=l.codm AND l.provincia=p.codp AND 
	u.provincia=l.provincia AND l.pueblo LIKE '%San Vicente%'
UNION
SELECT u.nombre,l.pueblo,p.nombre
FROM usuario u, localidad l, provincia p
WHERE u.pueblo=l.codm AND l.provincia=p.codp AND 
	u.provincia=l.provincia AND l.pueblo LIKE '%Valencia%'