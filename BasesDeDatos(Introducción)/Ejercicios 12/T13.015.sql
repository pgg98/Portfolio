select email,apellidos,u.nombre,p.nombre,l.pueblo
from tiendaonline.localidad l, tiendaonline.provincia p,
(
  select email,apellidos,nombre,provincia,pueblo from VusuAlm
  UNION
  select email,apellidos,nombre,provincia,pueblo from tiendaonline.usuario
) u
where u.provincia=l.provincia and u.pueblo=l.codm
  and l.provincia=p.codp