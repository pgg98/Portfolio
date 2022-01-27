
using System;
// Definición clase ConductorEN
namespace UnicarGenNHibernate.EN.Unicar
{
public partial class ConductorEN                                                                    : UnicarGenNHibernate.EN.Unicar.UsuarioEN


{
/**
 *	Atributo vehiculo
 */
private System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.VehiculoEN> vehiculo;



/**
 *	Atributo viaje
 */
private System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> viaje;



/**
 *	Atributo restriccion
 */
private string restriccion;






public virtual System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.VehiculoEN> Vehiculo {
        get { return vehiculo; } set { vehiculo = value;  }
}



public virtual System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> Viaje {
        get { return viaje; } set { viaje = value;  }
}



public virtual string Restriccion {
        get { return restriccion; } set { restriccion = value;  }
}





public ConductorEN() : base ()
{
        vehiculo = new System.Collections.Generic.List<UnicarGenNHibernate.EN.Unicar.VehiculoEN>();
        viaje = new System.Collections.Generic.List<UnicarGenNHibernate.EN.Unicar.ViajeEN>();
}



public ConductorEN(string nombre_usuario, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.VehiculoEN> vehiculo, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> viaje, string restriccion
                   , string nombre, string apellidos, string email, String pass, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ValoracionEN> valoracion, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.AlertaEN> alerta, double valoracionMedia, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum tipo
                   )
{
        this.init (Nombre_usuario, vehiculo, viaje, restriccion, nombre, apellidos, email, pass, valoracion, alerta, valoracionMedia, tipo);
}


public ConductorEN(ConductorEN conductor)
{
        this.init (Nombre_usuario, conductor.Vehiculo, conductor.Viaje, conductor.Restriccion, conductor.Nombre, conductor.Apellidos, conductor.Email, conductor.Pass, conductor.Valoracion, conductor.Alerta, conductor.ValoracionMedia, conductor.Tipo);
}

private void init (string nombre_usuario
                   , System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.VehiculoEN> vehiculo, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> viaje, string restriccion, string nombre, string apellidos, string email, String pass, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ValoracionEN> valoracion, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.AlertaEN> alerta, double valoracionMedia, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum tipo)
{
        this.Nombre_usuario = nombre_usuario;


        this.Vehiculo = vehiculo;

        this.Viaje = viaje;

        this.Restriccion = restriccion;

        this.Nombre = nombre;

        this.Apellidos = apellidos;

        this.Email = email;

        this.Pass = pass;

        this.Valoracion = valoracion;

        this.Alerta = alerta;

        this.ValoracionMedia = valoracionMedia;

        this.Tipo = tipo;
}

public override bool Equals (object obj)
{
        if (obj == null)
                return false;
        ConductorEN t = obj as ConductorEN;
        if (t == null)
                return false;
        if (Nombre_usuario.Equals (t.Nombre_usuario))
                return true;
        else
                return false;
}

public override int GetHashCode ()
{
        int hash = 13;

        hash += this.Nombre_usuario.GetHashCode ();
        return hash;
}
}
}
