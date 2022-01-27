SELECT p1.nombre, p2.nombre, l1.pueblo
FROM provincia p1, provincia p2, localidad l1, localidad l2
WHERE p1.codp<>p2.codp
	AND p1.codp=p2.codp
	AND p2.codp=l2.provincia
	AND l1.pueblo=l2.pueblo