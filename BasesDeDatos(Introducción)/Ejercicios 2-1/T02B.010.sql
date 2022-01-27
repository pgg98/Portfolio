SELECT email,'No tiene telefono'
FROM usuario u, provincia pv
WHERE pv.nombre='Murcia' AND u.provincia=codp AND telefono IS null