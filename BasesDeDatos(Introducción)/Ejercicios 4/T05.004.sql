SELECT p.nombre,l.pueblo
FROM localidad l
JOIN provincia p ON (l.provincia=p.codp)
WHERE p.nombre IN ('huesca','zaragoza','teruel') AND l.pueblo LIKE 'B%'
ORDER BY p.nombre,l.pueblo