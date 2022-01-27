
using System;
using System.Text;
using System.Collections.Generic;
using NHibernate;
using NHibernate.Cfg;
using NHibernate.Criterion;
using NHibernate.Exceptions;
using UnicarGenNHibernate.Exceptions;
using UnicarGenNHibernate.EN.Unicar;
using UnicarGenNHibernate.CAD.Unicar;


/*PROTECTED REGION ID(usingUnicarGenNHibernate.CEN.Unicar_Usuario_login) ENABLED START*/
//  references to other libraries
/*PROTECTED REGION END*/

namespace UnicarGenNHibernate.CEN.Unicar
{
public partial class UsuarioCEN
{
public string Login (string p_email, string p_pass)
{
        /*PROTECTED REGION ID(UnicarGenNHibernate.CEN.Unicar_Usuario_login) ENABLED START*/
        string result = null;

        IList<UsuarioEN> lista = DameUsuarioporEmail (p_email);

        if (lista.Count > 0) {
                UsuarioEN en = lista [0];
                if (en.Pass.Equals (Utils.Util.GetEncondeMD5 (p_pass)))
                        result = this.GetToken (en.Nombre_usuario);
        }

        return result;
        /*PROTECTED REGION END*/
}
}
}
