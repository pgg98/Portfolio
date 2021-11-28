SELECT v.email,v.nombre,v.apellidos,pp.total
FROM VusuAli v
LEFT JOIN TApedidos pp ON pp.usuario=v.email