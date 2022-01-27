
using System;
using UnicarGenNHibernate.EN.Unicar;

namespace UnicarGenNHibernate.CAD.Unicar
{
public partial interface ILocalidadCAD
{
LocalidadEN ReadOIDDefault (int id
                            );

void ModifyDefault (LocalidadEN localidad);

System.Collections.Generic.IList<LocalidadEN> ReadAllDefault (int first, int size);



int New_ (LocalidadEN localidad);

void Modify (LocalidadEN localidad);


void Destroy (int id
              );


LocalidadEN ReadOID (int id
                     );


System.Collections.Generic.IList<LocalidadEN> ReadAll (int first, int size);
}
}
