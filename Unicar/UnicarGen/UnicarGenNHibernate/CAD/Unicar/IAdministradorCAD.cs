
using System;
using UnicarGenNHibernate.EN.Unicar;

namespace UnicarGenNHibernate.CAD.Unicar
{
public partial interface IAdministradorCAD
{
AdministradorEN ReadOIDDefault (string nombre_usuario
                                );

void ModifyDefault (AdministradorEN administrador);

System.Collections.Generic.IList<AdministradorEN> ReadAllDefault (int first, int size);



string New_ (AdministradorEN administrador);

void Modify (AdministradorEN administrador);


void Destroy (string nombre_usuario
              );


AdministradorEN ReadOID (string nombre_usuario
                         );


System.Collections.Generic.IList<AdministradorEN> ReadAll (int first, int size);
}
}
