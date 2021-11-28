create or replace view TApedidos as
select p.numpedido,sum(importe*cantidad) total,date(fecha),usuario  
from pedido p join linped l on p.numpedido=l.numpedido 
where usuario in (select email from VusuAlm)
group by p.numpedido,date(fecha),usuario