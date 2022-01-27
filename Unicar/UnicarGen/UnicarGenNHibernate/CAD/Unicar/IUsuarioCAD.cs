
using System;
using UnicarGenNHibernate.EN.Unicar;

namespace UnicarGenNHibernate.CAD.Unicar
{
public partial interface IUsuarioCAD
{
UsuarioEN ReadOIDDefault (string nombre_usuario
                          );

void ModifyDefault (UsuarioEN usuario);

System.Collections.Generic.IList<UsuarioEN> ReadAllDefault (int first, int size);



string Registrarse (UsuarioEN usuario);

void Modificarperfil (UsuarioEN usuario);



UsuarioEN ReadOID (string nombre_usuario
                   );


System.Collections.Generic.IList<UsuarioEN> ReadAll (int first, int size);


void Darsebaja (string nombre_usuario
                );



System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.UsuarioEN> DameUsuarioporEmail (string p_email);
}
}
