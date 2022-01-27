

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
 *      Definition of the class PasajeroCEN
 *
 */
public partial class PasajeroCEN
{
private IPasajeroCAD _IPasajeroCAD;

public PasajeroCEN()
{
        this._IPasajeroCAD = new PasajeroCAD ();
}

public PasajeroCEN(IPasajeroCAD _IPasajeroCAD)
{
        this._IPasajeroCAD = _IPasajeroCAD;
}

public IPasajeroCAD get_IPasajeroCAD ()
{
        return this._IPasajeroCAD;
}

public string New_ (string p_nombre_usuario, string p_nombre, string p_apellidos, string p_email, String p_pass, double p_valoracionMedia, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum p_tipo)
{
        PasajeroEN pasajeroEN = null;
        string oid;

        //Initialized PasajeroEN
        pasajeroEN = new PasajeroEN ();
        pasajeroEN.Nombre_usuario = p_nombre_usuario;

        pasajeroEN.Nombre = p_nombre;

        pasajeroEN.Apellidos = p_apellidos;

        pasajeroEN.Email = p_email;

        pasajeroEN.Pass = Utils.Util.GetEncondeMD5 (p_pass);

        pasajeroEN.ValoracionMedia = p_valoracionMedia;

        pasajeroEN.Tipo = p_tipo;

        //Call to PasajeroCAD

        oid = _IPasajeroCAD.New_ (pasajeroEN);
        return oid;
}

public void Modify (string p_Pasajero_OID, string p_nombre, string p_apellidos, string p_email, String p_pass, double p_valoracionMedia, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum p_tipo)
{
        PasajeroEN pasajeroEN = null;

        //Initialized PasajeroEN
        pasajeroEN = new PasajeroEN ();
        pasajeroEN.Nombre_usuario = p_Pasajero_OID;
        pasajeroEN.Nombre = p_nombre;
        pasajeroEN.Apellidos = p_apellidos;
        pasajeroEN.Email = p_email;
        pasajeroEN.Pass = Utils.Util.GetEncondeMD5 (p_pass);
        pasajeroEN.ValoracionMedia = p_valoracionMedia;
        pasajeroEN.Tipo = p_tipo;
        //Call to PasajeroCAD

        _IPasajeroCAD.Modify (pasajeroEN);
}

public void Destroy (string nombre_usuario
                     )
{
        _IPasajeroCAD.Destroy (nombre_usuario);
}

public void AnyadirViaje (string p_Pasajero_OID, System.Collections.Generic.IList<int> p_viajes_OIDs)
{
        //Call to PasajeroCAD

        _IPasajeroCAD.AnyadirViaje (p_Pasajero_OID, p_viajes_OIDs);
}
public PasajeroEN ReadOID (string nombre_usuario
                           )
{
        PasajeroEN pasajeroEN = null;

        pasajeroEN = _IPasajeroCAD.ReadOID (nombre_usuario);
        return pasajeroEN;
}

public System.Collections.Generic.IList<PasajeroEN> ReadAll (int first, int size)
{
        System.Collections.Generic.IList<PasajeroEN> list = null;

        list = _IPasajeroCAD.ReadAll (first, size);
        return list;
}
}
}
