
using System;
using UnicarGenNHibernate.EN.Unicar;

namespace UnicarGenNHibernate.CAD.Unicar
{
public partial interface IValoracionCAD
{
ValoracionEN ReadOIDDefault (int id
                             );

void ModifyDefault (ValoracionEN valoracion);

System.Collections.Generic.IList<ValoracionEN> ReadAllDefault (int first, int size);



int Crearvaloracion (ValoracionEN valoracion);

void Modificarvaloracion (ValoracionEN valoracion);


void Eliminarvaloracion (int id
                         );


System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ValoracionEN> BuscarValoracionUsuario (string p_nombreUsuario);


ValoracionEN ReadOID (int id
                      );


System.Collections.Generic.IList<ValoracionEN> ReadAll (int first, int size);
}
}
