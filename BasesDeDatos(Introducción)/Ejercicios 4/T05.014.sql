select u.*, d.calle dcalle,d.calle2 dcalle2,d.codpos dcodpos,d.pueblo dpueblo,d.provincia dprovincia 
from usuario u 
left join direnvio d on (d.email=u.email) 
where u.provincia in ('46','03','12') 
and u.nombre like 'P%'