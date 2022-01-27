

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
 *      Definition of the class LocalidadCEN
 *
 */
public partial class LocalidadCEN
{
private ILocalidadCAD _ILocalidadCAD;

public LocalidadCEN()
{
        this._ILocalidadCAD = new LocalidadCAD ();
}

public LocalidadCEN(ILocalidadCAD _ILocalidadCAD)
{
        this._ILocalidadCAD = _ILocalidadCAD;
}

public ILocalidadCAD get_ILocalidadCAD ()
{
        return this._ILocalidadCAD;
}

public int New_ (string p_nombre, double p_latitud, double p_longitud)
{
        LocalidadEN localidadEN = null;
        int oid;

        //Initialized LocalidadEN
        localidadEN = new LocalidadEN ();
        localidadEN.Nombre = p_nombre;

        localidadEN.Latitud = p_latitud;

        localidadEN.Longitud = p_longitud;

        //Call to LocalidadCAD

        oid = _ILocalidadCAD.New_ (localidadEN);
        return oid;
}

public void Modify (int p_Localidad_OID, string p_nombre, double p_latitud, double p_longitud)
{
        LocalidadEN localidadEN = null;

        //Initialized LocalidadEN
        localidadEN = new LocalidadEN ();
        localidadEN.Id = p_Localidad_OID;
        localidadEN.Nombre = p_nombre;
        localidadEN.Latitud = p_latitud;
        localidadEN.Longitud = p_longitud;
        //Call to LocalidadCAD

        _ILocalidadCAD.Modify (localidadEN);
}

public void Destroy (int id
                     )
{
        _ILocalidadCAD.Destroy (id);
}

public LocalidadEN ReadOID (int id
                            )
{
        LocalidadEN localidadEN = null;

        localidadEN = _ILocalidadCAD.ReadOID (id);
        return localidadEN;
}

public System.Collections.Generic.IList<LocalidadEN> ReadAll (int first, int size)
{
        System.Collections.Generic.IList<LocalidadEN> list = null;

        list = _ILocalidadCAD.ReadAll (first, size);
        return list;
}
}
}
