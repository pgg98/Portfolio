

using System;
using System.Text;
using System.Collections.Generic;
using Newtonsoft.Json;
using NHibernate;
using NHibernate.Cfg;
using NHibernate.Criterion;
using NHibernate.Exceptions;
using UnicarGenNHibernate.Exceptions;

using UnicarGenNHibernate.EN.Unicar;
using UnicarGenNHibernate.CAD.Unicar;


namespace UnicarGenNHibernate.CEN.Unicar
{
/*
 *      Definition of the class UsuarioCEN
 *
 */
public partial class UsuarioCEN
{
private IUsuarioCAD _IUsuarioCAD;

public UsuarioCEN()
{
        this._IUsuarioCAD = new UsuarioCAD ();
}

public UsuarioCEN(IUsuarioCAD _IUsuarioCAD)
{
        this._IUsuarioCAD = _IUsuarioCAD;
}

public IUsuarioCAD get_IUsuarioCAD ()
{
        return this._IUsuarioCAD;
}

public string Registrarse (string p_nombre_usuario, string p_nombre, string p_apellidos, string p_email, String p_pass, double p_valoracionMedia, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum p_tipo)
{
        UsuarioEN usuarioEN = null;
        string oid;

        //Initialized UsuarioEN
        usuarioEN = new UsuarioEN ();
        usuarioEN.Nombre_usuario = p_nombre_usuario;

        usuarioEN.Nombre = p_nombre;

        usuarioEN.Apellidos = p_apellidos;

        usuarioEN.Email = p_email;

        usuarioEN.Pass = Utils.Util.GetEncondeMD5 (p_pass);

        usuarioEN.ValoracionMedia = p_valoracionMedia;

        usuarioEN.Tipo = p_tipo;

        //Call to UsuarioCAD

        oid = _IUsuarioCAD.Registrarse (usuarioEN);
        return oid;
}

public void Modificarperfil (string p_Usuario_OID, string p_nombre, string p_apellidos, string p_email, String p_pass, double p_valoracionMedia, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum p_tipo)
{
        UsuarioEN usuarioEN = null;

        //Initialized UsuarioEN
        usuarioEN = new UsuarioEN ();
        usuarioEN.Nombre_usuario = p_Usuario_OID;
        usuarioEN.Nombre = p_nombre;
        usuarioEN.Apellidos = p_apellidos;
        usuarioEN.Email = p_email;
        usuarioEN.Pass = Utils.Util.GetEncondeMD5 (p_pass);
        usuarioEN.ValoracionMedia = p_valoracionMedia;
        usuarioEN.Tipo = p_tipo;
        //Call to UsuarioCAD

        _IUsuarioCAD.Modificarperfil (usuarioEN);
}

public UsuarioEN ReadOID (string nombre_usuario
                          )
{
        UsuarioEN usuarioEN = null;

        usuarioEN = _IUsuarioCAD.ReadOID (nombre_usuario);
        return usuarioEN;
}

public System.Collections.Generic.IList<UsuarioEN> ReadAll (int first, int size)
{
        System.Collections.Generic.IList<UsuarioEN> list = null;

        list = _IUsuarioCAD.ReadAll (first, size);
        return list;
}
public void Darsebaja (string nombre_usuario
                       )
{
        _IUsuarioCAD.Darsebaja (nombre_usuario);
}

public System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.UsuarioEN> DameUsuarioporEmail (string p_email)
{
        return _IUsuarioCAD.DameUsuarioporEmail (p_email);
}



private string Encode (string nombre_usuario)
{
        var payload = new Dictionary<string, object>(){
                { "nombre_usuario", nombre_usuario }
        };
        string token = Jose.JWT.Encode (payload, Utils.Util.getKey (), Jose.JwsAlgorithm.HS256);

        return token;
}

public string GetToken (string nombre_usuario)
{
        UsuarioEN en = _IUsuarioCAD.ReadOIDDefault (nombre_usuario);
        string token = Encode (en.Nombre_usuario);

        return token;
}
public string CheckToken (string token)
{
        string result = null;

        try
        {
                string decodedToken = Utils.Util.Decode (token);



                string id = (string)ObtenerNOMBRE_USUARIO (decodedToken);

                UsuarioEN en = _IUsuarioCAD.ReadOIDDefault (id);

                if (en != null && ((string)en.Nombre_usuario).Equals (ObtenerNOMBRE_USUARIO (decodedToken))
                    ) {
                        result = id;
                }
                else throw new ModelException ("El token es incorrecto");
        } catch (Exception e)
        {
                throw new ModelException ("El token es incorrecto");
        }

        return result;
}


public string ObtenerNOMBRE_USUARIO (string decodedToken)
{
        try
        {
                Dictionary<string, object> results = JsonConvert.DeserializeObject<Dictionary<string, object> >(decodedToken);
                string nombre_usuario = (string)results ["nombre_usuario"];
                return nombre_usuario;
        }
        catch
        {
                throw new Exception ("El token enviado no es correcto");
        }
}
}
}
