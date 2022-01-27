

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
 *      Definition of the class VehiculoCEN
 *
 */
public partial class VehiculoCEN
{
private IVehiculoCAD _IVehiculoCAD;

public VehiculoCEN()
{
        this._IVehiculoCAD = new VehiculoCAD ();
}

public VehiculoCEN(IVehiculoCAD _IVehiculoCAD)
{
        this._IVehiculoCAD = _IVehiculoCAD;
}

public IVehiculoCAD get_IVehiculoCAD ()
{
        return this._IVehiculoCAD;
}

public string New_ (string p_matricula, string p_marca, string p_modelo, string p_conductor)
{
        VehiculoEN vehiculoEN = null;
        string oid;

        //Initialized VehiculoEN
        vehiculoEN = new VehiculoEN ();
        vehiculoEN.Matricula = p_matricula;

        vehiculoEN.Marca = p_marca;

        vehiculoEN.Modelo = p_modelo;


        if (p_conductor != null) {
                // El argumento p_conductor -> Property conductor es oid = false
                // Lista de oids matricula
                vehiculoEN.Conductor = new UnicarGenNHibernate.EN.Unicar.ConductorEN ();
                vehiculoEN.Conductor.Nombre_usuario = p_conductor;
        }

        //Call to VehiculoCAD

        oid = _IVehiculoCAD.New_ (vehiculoEN);
        return oid;
}

public void Modify (string p_Vehiculo_OID, string p_marca, string p_modelo)
{
        VehiculoEN vehiculoEN = null;

        //Initialized VehiculoEN
        vehiculoEN = new VehiculoEN ();
        vehiculoEN.Matricula = p_Vehiculo_OID;
        vehiculoEN.Marca = p_marca;
        vehiculoEN.Modelo = p_modelo;
        //Call to VehiculoCAD

        _IVehiculoCAD.Modify (vehiculoEN);
}

public void Destroy (string matricula
                     )
{
        _IVehiculoCAD.Destroy (matricula);
}

public VehiculoEN ReadOID (string matricula
                           )
{
        VehiculoEN vehiculoEN = null;

        vehiculoEN = _IVehiculoCAD.ReadOID (matricula);
        return vehiculoEN;
}

public System.Collections.Generic.IList<VehiculoEN> ReadAll (int first, int size)
{
        System.Collections.Generic.IList<VehiculoEN> list = null;

        list = _IVehiculoCAD.ReadAll (first, size);
        return list;
}
public void QuitarViaje (string p_Vehiculo_OID, System.Collections.Generic.IList<int> p_viaje_OIDs)
{
        //Call to VehiculoCAD

        _IVehiculoCAD.QuitarViaje (p_Vehiculo_OID, p_viaje_OIDs);
}
}
}
