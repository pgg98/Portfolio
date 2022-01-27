
using System;
// Definición clase PasajeroEN
namespace UnicarGenNHibernate.EN.Unicar
{
public partial class PasajeroEN                                                                     : UnicarGenNHibernate.EN.Unicar.UsuarioEN


{
/**
 *	Atributo viajes
 */
private System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> viajes;






public virtual System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> Viajes {
        get { return viajes; } set { viajes = value;  }
}





public PasajeroEN() : base ()
{
        viajes = new System.Collections.Generic.List<UnicarGenNHibernate.EN.Unicar.ViajeEN>();
}



public PasajeroEN(string nombre_usuario, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> viajes
                  , string nombre, string apellidos, string email, String pass, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ValoracionEN> valoracion, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.AlertaEN> alerta, double valoracionMedia, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum tipo
                  )
{
        this.init (Nombre_usuario, viajes, nombre, apellidos, email, pass, valoracion, alerta, valoracionMedia, tipo);
}


public PasajeroEN(PasajeroEN pasajero)
{
        this.init (Nombre_usuario, pasajero.Viajes, pasajero.Nombre, pasajero.Apellidos, pasajero.Email, pasajero.Pass, pasajero.Valoracion, pasajero.Alerta, pasajero.ValoracionMedia, pasajero.Tipo);
}

private void init (string nombre_usuario
                   , System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> viajes, string nombre, string apellidos, string email, String pass, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ValoracionEN> valoracion, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.AlertaEN> alerta, double valoracionMedia, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum tipo)
{
        this.Nombre_usuario = nombre_usuario;


        this.Viajes = viajes;

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
        PasajeroEN t = obj as PasajeroEN;
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
