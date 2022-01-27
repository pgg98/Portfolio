
using System;
using UnicarGenNHibernate.EN.Unicar;

namespace UnicarGenNHibernate.CAD.Unicar
{
public partial interface IConductorCAD
{
ConductorEN ReadOIDDefault (string nombre_usuario
                            );

void ModifyDefault (ConductorEN conductor);

System.Collections.Generic.IList<ConductorEN> ReadAllDefault (int first, int size);



string New_ (ConductorEN conductor);

void Modify (ConductorEN conductor);


void Destroy (string nombre_usuario
              );



ConductorEN ReadOID (string nombre_usuario
                     );


System.Collections.Generic.IList<ConductorEN> ReadAll (int first, int size);
}
}
