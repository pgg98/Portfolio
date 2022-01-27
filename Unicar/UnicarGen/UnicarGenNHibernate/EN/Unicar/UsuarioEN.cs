
using System;
// Definición clase UsuarioEN
namespace UnicarGenNHibernate.EN.Unicar
{
public partial class UsuarioEN
{
/**
 *	Atributo nombre_usuario
 */
private string nombre_usuario;



/**
 *	Atributo nombre
 */
private string nombre;



/**
 *	Atributo apellidos
 */
private string apellidos;



/**
 *	Atributo email
 */
private string email;



/**
 *	Atributo pass
 */
private String pass;



/**
 *	Atributo valoracion
 */
private System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ValoracionEN> valoracion;



/**
 *	Atributo alerta
 */
private System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.AlertaEN> alerta;



/**
 *	Atributo valoracionMedia
 */
private double valoracionMedia;



/**
 *	Atributo tipo
 */
private UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum tipo;






public virtual string Nombre_usuario {
        get { return nombre_usuario; } set { nombre_usuario = value;  }
}



public virtual string Nombre {
        get { return nombre; } set { nombre = value;  }
}



public virtual string Apellidos {
        get { return apellidos; } set { apellidos = value;  }
}



public virtual string Email {
        get { return email; } set { email = value;  }
}



public virtual String Pass {
        get { return pass; } set { pass = value;  }
}



public virtual System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ValoracionEN> Valoracion {
        get { return valoracion; } set { valoracion = value;  }
}



public virtual System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.AlertaEN> Alerta {
        get { return alerta; } set { alerta = value;  }
}



public virtual double ValoracionMedia {
        get { return valoracionMedia; } set { valoracionMedia = value;  }
}



public virtual UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum Tipo {
        get { return tipo; } set { tipo = value;  }
}





public UsuarioEN()
{
        valoracion = new System.Collections.Generic.List<UnicarGenNHibernate.EN.Unicar.ValoracionEN>();
        alerta = new System.Collections.Generic.List<UnicarGenNHibernate.EN.Unicar.AlertaEN>();
}



public UsuarioEN(string nombre_usuario, string nombre, string apellidos, string email, String pass, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ValoracionEN> valoracion, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.AlertaEN> alerta, double valoracionMedia, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum tipo
                 )
{
        this.init (Nombre_usuario, nombre, apellidos, email, pass, valoracion, alerta, valoracionMedia, tipo);
}


public UsuarioEN(UsuarioEN usuario)
{
        this.init (Nombre_usuario, usuario.Nombre, usuario.Apellidos, usuario.Email, usuario.Pass, usuario.Valoracion, usuario.Alerta, usuario.ValoracionMedia, usuario.Tipo);
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
        UsuarioEN t = obj as UsuarioEN;
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
