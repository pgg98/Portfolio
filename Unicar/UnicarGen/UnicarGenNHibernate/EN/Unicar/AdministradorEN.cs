
using System;
// Definición clase AdministradorEN
namespace UnicarGenNHibernate.EN.Unicar
{
public partial class AdministradorEN                                                                        : UnicarGenNHibernate.EN.Unicar.UsuarioEN


{
public AdministradorEN() : base ()
{
}



public AdministradorEN(string nombre_usuario,
                       string nombre, string apellidos, string email, String pass, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ValoracionEN> valoracion, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.AlertaEN> alerta, double valoracionMedia, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum tipo
                       )
{
        this.init (Nombre_usuario, nombre, apellidos, email, pass, valoracion, alerta, valoracionMedia, tipo);
}


public AdministradorEN(AdministradorEN administrador)
{
        this.init (Nombre_usuario, administrador.Nombre, administrador.Apellidos, administrador.Email, administrador.Pass, administrador.Valoracion, administrador.Alerta, administrador.ValoracionMedia, administrador.Tipo);
}

private void init (string nombre_usuario
                   , string nombre, string apellidos, string email, String pass, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ValoracionEN> valoracion, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.AlertaEN> alerta, double valoracionMedia, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum tipo)
{
        this.Nombre_usuario = nombre_usuario;


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
        AdministradorEN t = obj as AdministradorEN;
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
