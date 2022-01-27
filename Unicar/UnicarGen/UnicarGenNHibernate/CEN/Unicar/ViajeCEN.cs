

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
 *      Definition of the class ViajeCEN
 *
 */
public partial class ViajeCEN
{
private IViajeCAD _IViajeCAD;

public ViajeCEN()
{
        this._IViajeCAD = new ViajeCAD ();
}

public ViajeCEN(IViajeCAD _IViajeCAD)
{
        this._IViajeCAD = _IViajeCAD;
}

public IViajeCAD get_IViajeCAD ()
{
        return this._IViajeCAD;
}

public int New_ (Nullable<DateTime> p_fechasalida, Nullable<DateTime> p_fechallegada, string p_conductor, int p_plazas, double p_precio, string p_vehiculo, int p_direccionLlegada, int p_direccionSalida, int p_plazasocupadas, Nullable<DateTime> p_horasalida, Nullable<DateTime> p_horallegada)
{
        ViajeEN viajeEN = null;
        int oid;

        //Initialized ViajeEN
        viajeEN = new ViajeEN ();
        viajeEN.Fechasalida = p_fechasalida;

        viajeEN.Fechallegada = p_fechallegada;


        if (p_conductor != null) {
                // El argumento p_conductor -> Property conductor es oid = false
                // Lista de oids id
                viajeEN.Conductor = new UnicarGenNHibernate.EN.Unicar.ConductorEN ();
                viajeEN.Conductor.Nombre_usuario = p_conductor;
        }

        viajeEN.Plazas = p_plazas;

        viajeEN.Precio = p_precio;


        if (p_vehiculo != null) {
                // El argumento p_vehiculo -> Property vehiculo es oid = false
                // Lista de oids id
                viajeEN.Vehiculo = new UnicarGenNHibernate.EN.Unicar.VehiculoEN ();
                viajeEN.Vehiculo.Matricula = p_vehiculo;
        }


        if (p_direccionLlegada != -1) {
                // El argumento p_direccionLlegada -> Property direccionLlegada es oid = false
                // Lista de oids id
                viajeEN.DireccionLlegada = new UnicarGenNHibernate.EN.Unicar.DireccionEN ();
                viajeEN.DireccionLlegada.Id = p_direccionLlegada;
        }


        if (p_direccionSalida != -1) {
                // El argumento p_direccionSalida -> Property direccionSalida es oid = false
                // Lista de oids id
                viajeEN.DireccionSalida = new UnicarGenNHibernate.EN.Unicar.DireccionEN ();
                viajeEN.DireccionSalida.Id = p_direccionSalida;
        }

        viajeEN.Plazasocupadas = p_plazasocupadas;

        viajeEN.Horasalida = p_horasalida;

        viajeEN.Horallegada = p_horallegada;

        //Call to ViajeCAD

        oid = _IViajeCAD.New_ (viajeEN);
        return oid;
}

public void Modify (int p_Viaje_OID, Nullable<DateTime> p_fechasalida, Nullable<DateTime> p_fechallegada, int p_plazas, double p_precio, int p_plazasocupadas, Nullable<DateTime> p_horasalida, Nullable<DateTime> p_horallegada)
{
        ViajeEN viajeEN = null;

        //Initialized ViajeEN
        viajeEN = new ViajeEN ();
        viajeEN.Id = p_Viaje_OID;
        viajeEN.Fechasalida = p_fechasalida;
        viajeEN.Fechallegada = p_fechallegada;
        viajeEN.Plazas = p_plazas;
        viajeEN.Precio = p_precio;
        viajeEN.Plazasocupadas = p_plazasocupadas;
        viajeEN.Horasalida = p_horasalida;
        viajeEN.Horallegada = p_horallegada;
        //Call to ViajeCAD

        _IViajeCAD.Modify (viajeEN);
}

public ViajeEN ReadOID (int id
                        )
{
        ViajeEN viajeEN = null;

        viajeEN = _IViajeCAD.ReadOID (id);
        return viajeEN;
}

public System.Collections.Generic.IList<ViajeEN> ReadAll (int first, int size)
{
        System.Collections.Generic.IList<ViajeEN> list = null;

        list = _IViajeCAD.ReadAll (first, size);
        return list;
}
public System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> BuscarViajeDireccion (string p_NombreLocalidad)
{
        return _IViajeCAD.BuscarViajeDireccion (p_NombreLocalidad);
}
public System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> BuscarViajeConductor (string p_nombreUsuario)
{
        return _IViajeCAD.BuscarViajeConductor (p_nombreUsuario);
}
public System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> BuscarViajePorPasajero (string p_pasajero)
{
        return _IViajeCAD.BuscarViajePorPasajero (p_pasajero);
}
public void QuitarPasajero (int p_Viaje_OID, System.Collections.Generic.IList<string> p_pasajeros_OIDs)
{
        //Call to ViajeCAD

        _IViajeCAD.QuitarPasajero (p_Viaje_OID, p_pasajeros_OIDs);
}
public void Destroy (int id
                     )
{
        _IViajeCAD.Destroy (id);
}

public void AnyadirPasajero (int p_Viaje_OID, System.Collections.Generic.IList<string> p_pasajeros_OIDs)
{
        //Call to ViajeCAD

        _IViajeCAD.AnyadirPasajero (p_Viaje_OID, p_pasajeros_OIDs);
}
}
}
