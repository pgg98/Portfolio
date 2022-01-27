

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
 *      Definition of the class ConductorCEN
 *
 */
public partial class ConductorCEN
{
private IConductorCAD _IConductorCAD;

public ConductorCEN()
{
        this._IConductorCAD = new ConductorCAD ();
}

public ConductorCEN(IConductorCAD _IConductorCAD)
{
        this._IConductorCAD = _IConductorCAD;
}

public IConductorCAD get_IConductorCAD ()
{
        return this._IConductorCAD;
}

public string New_ (string p_nombre_usuario, string p_nombre, string p_apellidos, string p_email, String p_pass, double p_valoracionMedia, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum p_tipo, string p_restriccion)
{
        ConductorEN conductorEN = null;
        string oid;

        //Initialized ConductorEN
        conductorEN = new ConductorEN ();
        conductorEN.Nombre_usuario = p_nombre_usuario;

        conductorEN.Nombre = p_nombre;

        conductorEN.Apellidos = p_apellidos;

        conductorEN.Email = p_email;

        conductorEN.Pass = Utils.Util.GetEncondeMD5 (p_pass);

        conductorEN.ValoracionMedia = p_valoracionMedia;

        conductorEN.Tipo = p_tipo;

        conductorEN.Restriccion = p_restriccion;

        //Call to ConductorCAD

        oid = _IConductorCAD.New_ (conductorEN);
        return oid;
}

public void Modify (string p_Conductor_OID, string p_nombre, string p_apellidos, string p_email, String p_pass, double p_valoracionMedia, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum p_tipo, string p_restriccion)
{
        ConductorEN conductorEN = null;

        //Initialized ConductorEN
        conductorEN = new ConductorEN ();
        conductorEN.Nombre_usuario = p_Conductor_OID;
        conductorEN.Nombre = p_nombre;
        conductorEN.Apellidos = p_apellidos;
        conductorEN.Email = p_email;
        conductorEN.Pass = Utils.Util.GetEncondeMD5 (p_pass);
        conductorEN.ValoracionMedia = p_valoracionMedia;
        conductorEN.Tipo = p_tipo;
        conductorEN.Restriccion = p_restriccion;
        //Call to ConductorCAD

        _IConductorCAD.Modify (conductorEN);
}

public void Destroy (string nombre_usuario
                     )
{
        _IConductorCAD.Destroy (nombre_usuario);
}

public ConductorEN ReadOID (string nombre_usuario
                            )
{
        ConductorEN conductorEN = null;

        conductorEN = _IConductorCAD.ReadOID (nombre_usuario);
        return conductorEN;
}

public System.Collections.Generic.IList<ConductorEN> ReadAll (int first, int size)
{
        System.Collections.Generic.IList<ConductorEN> list = null;

        list = _IConductorCAD.ReadAll (first, size);
        return list;
}
}
}
