
using System;
using UnicarGenNHibernate.EN.Unicar;

namespace UnicarGenNHibernate.CAD.Unicar
{
public partial interface IDireccionCAD
{
DireccionEN ReadOIDDefault (int id
                            );

void ModifyDefault (DireccionEN direccion);

System.Collections.Generic.IList<DireccionEN> ReadAllDefault (int first, int size);



int New_ (DireccionEN direccion);

void Modify (DireccionEN direccion);


void Destroy (int id
              );


DireccionEN ReadOID (int id
                     );


System.Collections.Generic.IList<DireccionEN> ReadAll (int first, int size);
}
}
