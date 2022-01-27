
using System;
// Definición clase ViajeEN
namespace UnicarGenNHibernate.EN.Unicar
{
public partial class ViajeEN
{
/**
 *	Atributo id
 */
private int id;



/**
 *	Atributo fechasalida
 */
private Nullable<DateTime> fechasalida;



/**
 *	Atributo fechallegada
 */
private Nullable<DateTime> fechallegada;



/**
 *	Atributo pasajeros
 */
private System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.PasajeroEN> pasajeros;



/**
 *	Atributo conductor
 */
private UnicarGenNHibernate.EN.Unicar.ConductorEN conductor;



/**
 *	Atributo plazas
 */
private int plazas;



/**
 *	Atributo precio
 */
private double precio;



/**
 *	Atributo valoracion
 */
private System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ValoracionEN> valoracion;



/**
 *	Atributo alerta
 */
private System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.AlertaEN> alerta;



/**
 *	Atributo vehiculo
 */
private UnicarGenNHibernate.EN.Unicar.VehiculoEN vehiculo;



/**
 *	Atributo direccionLlegada
 */
private UnicarGenNHibernate.EN.Unicar.DireccionEN direccionLlegada;



/**
 *	Atributo direccionSalida
 */
private UnicarGenNHibernate.EN.Unicar.DireccionEN direccionSalida;



/**
 *	Atributo plazasocupadas
 */
private int plazasocupadas;



/**
 *	Atributo horasalida
 */
private Nullable<DateTime> horasalida;



/**
 *	Atributo horallegada
 */
private Nullable<DateTime> horallegada;






public virtual int Id {
        get { return id; } set { id = value;  }
}



public virtual Nullable<DateTime> Fechasalida {
        get { return fechasalida; } set { fechasalida = value;  }
}



public virtual Nullable<DateTime> Fechallegada {
        get { return fechallegada; } set { fechallegada = value;  }
}



public virtual System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.PasajeroEN> Pasajeros {
        get { return pasajeros; } set { pasajeros = value;  }
}



public virtual UnicarGenNHibernate.EN.Unicar.ConductorEN Conductor {
        get { return conductor; } set { conductor = value;  }
}



public virtual int Plazas {
        get { return plazas; } set { plazas = value;  }
}



public virtual double Precio {
        get { return precio; } set { precio = value;  }
}



public virtual System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ValoracionEN> Valoracion {
        get { return valoracion; } set { valoracion = value;  }
}



public virtual System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.AlertaEN> Alerta {
        get { return alerta; } set { alerta = value;  }
}



public virtual UnicarGenNHibernate.EN.Unicar.VehiculoEN Vehiculo {
        get { return vehiculo; } set { vehiculo = value;  }
}



public virtual UnicarGenNHibernate.EN.Unicar.DireccionEN DireccionLlegada {
        get { return direccionLlegada; } set { direccionLlegada = value;  }
}



public virtual UnicarGenNHibernate.EN.Unicar.DireccionEN DireccionSalida {
        get { return direccionSalida; } set { direccionSalida = value;  }
}



public virtual int Plazasocupadas {
        get { return plazasocupadas; } set { plazasocupadas = value;  }
}



public virtual Nullable<DateTime> Horasalida {
        get { return horasalida; } set { horasalida = value;  }
}



public virtual Nullable<DateTime> Horallegada {
        get { return horallegada; } set { horallegada = value;  }
}





public ViajeEN()
{
        pasajeros = new System.Collections.Generic.List<UnicarGenNHibernate.EN.Unicar.PasajeroEN>();
        valoracion = new System.Collections.Generic.List<UnicarGenNHibernate.EN.Unicar.ValoracionEN>();
        alerta = new System.Collections.Generic.List<UnicarGenNHibernate.EN.Unicar.AlertaEN>();
}



public ViajeEN(int id, Nullable<DateTime> fechasalida, Nullable<DateTime> fechallegada, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.PasajeroEN> pasajeros, UnicarGenNHibernate.EN.Unicar.ConductorEN conductor, int plazas, double precio, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ValoracionEN> valoracion, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.AlertaEN> alerta, UnicarGenNHibernate.EN.Unicar.VehiculoEN vehiculo, UnicarGenNHibernate.EN.Unicar.DireccionEN direccionLlegada, UnicarGenNHibernate.EN.Unicar.DireccionEN direccionSalida, int plazasocupadas, Nullable<DateTime> horasalida, Nullable<DateTime> horallegada
               )
{
        this.init (Id, fechasalida, fechallegada, pasajeros, conductor, plazas, precio, valoracion, alerta, vehiculo, direccionLlegada, direccionSalida, plazasocupadas, horasalida, horallegada);
}


public ViajeEN(ViajeEN viaje)
{
        this.init (Id, viaje.Fechasalida, viaje.Fechallegada, viaje.Pasajeros, viaje.Conductor, viaje.Plazas, viaje.Precio, viaje.Valoracion, viaje.Alerta, viaje.Vehiculo, viaje.DireccionLlegada, viaje.DireccionSalida, viaje.Plazasocupadas, viaje.Horasalida, viaje.Horallegada);
}

private void init (int id
                   , Nullable<DateTime> fechasalida, Nullable<DateTime> fechallegada, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.PasajeroEN> pasajeros, UnicarGenNHibernate.EN.Unicar.ConductorEN conductor, int plazas, double precio, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ValoracionEN> valoracion, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.AlertaEN> alerta, UnicarGenNHibernate.EN.Unicar.VehiculoEN vehiculo, UnicarGenNHibernate.EN.Unicar.DireccionEN direccionLlegada, UnicarGenNHibernate.EN.Unicar.DireccionEN direccionSalida, int plazasocupadas, Nullable<DateTime> horasalida, Nullable<DateTime> horallegada)
{
        this.Id = id;


        this.Fechasalida = fechasalida;

        this.Fechallegada = fechallegada;

        this.Pasajeros = pasajeros;

        this.Conductor = conductor;

        this.Plazas = plazas;

        this.Precio = precio;

        this.Valoracion = valoracion;

        this.Alerta = alerta;

        this.Vehiculo = vehiculo;

        this.DireccionLlegada = direccionLlegada;

        this.DireccionSalida = direccionSalida;

        this.Plazasocupadas = plazasocupadas;

        this.Horasalida = horasalida;

        this.Horallegada = horallegada;
}

public override bool Equals (object obj)
{
        if (obj == null)
                return false;
        ViajeEN t = obj as ViajeEN;
        if (t == null)
                return false;
        if (Id.Equals (t.Id))
                return true;
        else
                return false;
}

public override int GetHashCode ()
{
        int hash = 13;

        hash += this.Id.GetHashCode ();
        return hash;
}
}
}
