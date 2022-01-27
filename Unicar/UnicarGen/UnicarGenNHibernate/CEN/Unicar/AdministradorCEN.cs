

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
 *      Definition of the class AdministradorCEN
 *
 */
public partial class AdministradorCEN
{
private IAdministradorCAD _IAdministradorCAD;

public AdministradorCEN()
{
        this._IAdministradorCAD = new AdministradorCAD ();
}

public AdministradorCEN(IAdministradorCAD _IAdministradorCAD)
{
        this._IAdministradorCAD = _IAdministradorCAD;
}

public IAdministradorCAD get_IAdministradorCAD ()
{
        return this._IAdministradorCAD;
}

public string New_ (string p_nombre_usuario, string p_nombre, string p_apellidos, string p_email, String p_pass, double p_valoracionMedia, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum p_tipo)
{
        AdministradorEN administradorEN = null;
        string oid;

        //Initialized AdministradorEN
        administradorEN = new AdministradorEN ();
        administradorEN.Nombre_usuario = p_nombre_usuario;

        administradorEN.Nombre = p_nombre;

        administradorEN.Apellidos = p_apellidos;

        administradorEN.Email = p_email;

        administradorEN.Pass = Utils.Util.GetEncondeMD5 (p_pass);

        administradorEN.ValoracionMedia = p_valoracionMedia;

        administradorEN.Tipo = p_tipo;

        //Call to AdministradorCAD

        oid = _IAdministradorCAD.New_ (administradorEN);
        return oid;
}

public void Modify (string p_Administrador_OID, string p_nombre, string p_apellidos, string p_email, String p_pass, double p_valoracionMedia, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum p_tipo)
{
        AdministradorEN administradorEN = null;

        //Initialized AdministradorEN
        administradorEN = new AdministradorEN ();
        administradorEN.Nombre_usuario = p_Administrador_OID;
        administradorEN.Nombre = p_nombre;
        administradorEN.Apellidos = p_apellidos;
        administradorEN.Email = p_email;
        administradorEN.Pass = Utils.Util.GetEncondeMD5 (p_pass);
        administradorEN.ValoracionMedia = p_valoracionMedia;
        administradorEN.Tipo = p_tipo;
        //Call to AdministradorCAD

        _IAdministradorCAD.Modify (administradorEN);
}

public void Destroy (string nombre_usuario
                     )
{
        _IAdministradorCAD.Destroy (nombre_usuario);
}

public AdministradorEN ReadOID (string nombre_usuario
                                )
{
        AdministradorEN administradorEN = null;

        administradorEN = _IAdministradorCAD.ReadOID (nombre_usuario);
        return administradorEN;
}

public System.Collections.Generic.IList<AdministradorEN> ReadAll (int first, int size)
{
        System.Collections.Generic.IList<AdministradorEN> list = null;

        list = _IAdministradorCAD.ReadAll (first, size);
        return list;
}
}
}
