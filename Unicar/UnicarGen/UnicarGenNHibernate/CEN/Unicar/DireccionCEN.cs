

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
 *      Definition of the class DireccionCEN
 *
 */
public partial class DireccionCEN
{
private IDireccionCAD _IDireccionCAD;

public DireccionCEN()
{
        this._IDireccionCAD = new DireccionCAD ();
}

public DireccionCEN(IDireccionCAD _IDireccionCAD)
{
        this._IDireccionCAD = _IDireccionCAD;
}

public IDireccionCAD get_IDireccionCAD ()
{
        return this._IDireccionCAD;
}

public int New_ (int p_localidad, string p_direccion)
{
        DireccionEN direccionEN = null;
        int oid;

        //Initialized DireccionEN
        direccionEN = new DireccionEN ();

        if (p_localidad != -1) {
                // El argumento p_localidad -> Property localidad es oid = false
                // Lista de oids id
                direccionEN.Localidad = new UnicarGenNHibernate.EN.Unicar.LocalidadEN ();
                direccionEN.Localidad.Id = p_localidad;
        }

        direccionEN.Direccion = p_direccion;

        //Call to DireccionCAD

        oid = _IDireccionCAD.New_ (direccionEN);
        return oid;
}

public void Modify (int p_Direccion_OID, string p_direccion)
{
        DireccionEN direccionEN = null;

        //Initialized DireccionEN
        direccionEN = new DireccionEN ();
        direccionEN.Id = p_Direccion_OID;
        direccionEN.Direccion = p_direccion;
        //Call to DireccionCAD

        _IDireccionCAD.Modify (direccionEN);
}

public void Destroy (int id
                     )
{
        _IDireccionCAD.Destroy (id);
}

public DireccionEN ReadOID (int id
                            )
{
        DireccionEN direccionEN = null;

        direccionEN = _IDireccionCAD.ReadOID (id);
        return direccionEN;
}

public System.Collections.Generic.IList<DireccionEN> ReadAll (int first, int size)
{
        System.Collections.Generic.IList<DireccionEN> list = null;

        list = _IDireccionCAD.ReadAll (first, size);
        return list;
}
}
}
