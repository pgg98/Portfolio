
using System;
// Definición clase AlertaEN
namespace UnicarGenNHibernate.EN.Unicar
{
public partial class AlertaEN
{
/**
 *	Atributo id
 */
private int id;



/**
 *	Atributo tipo
 */
private UnicarGenNHibernate.Enumerated.Unicar.TipoAlertaEnum tipo;



/**
 *	Atributo viaje
 */
private UnicarGenNHibernate.EN.Unicar.ViajeEN viaje;



/**
 *	Atributo usuario
 */
private UnicarGenNHibernate.EN.Unicar.UsuarioEN usuario;






public virtual int Id {
        get { return id; } set { id = value;  }
}



public virtual UnicarGenNHibernate.Enumerated.Unicar.TipoAlertaEnum Tipo {
        get { return tipo; } set { tipo = value;  }
}



public virtual UnicarGenNHibernate.EN.Unicar.ViajeEN Viaje {
        get { return viaje; } set { viaje = value;  }
}



public virtual UnicarGenNHibernate.EN.Unicar.UsuarioEN Usuario {
        get { return usuario; } set { usuario = value;  }
}





public AlertaEN()
{
}



public AlertaEN(int id, UnicarGenNHibernate.Enumerated.Unicar.TipoAlertaEnum tipo, UnicarGenNHibernate.EN.Unicar.ViajeEN viaje, UnicarGenNHibernate.EN.Unicar.UsuarioEN usuario
                )
{
        this.init (Id, tipo, viaje, usuario);
}


public AlertaEN(AlertaEN alerta)
{
        this.init (Id, alerta.Tipo, alerta.Viaje, alerta.Usuario);
}

private void init (int id
                   , UnicarGenNHibernate.Enumerated.Unicar.TipoAlertaEnum tipo, UnicarGenNHibernate.EN.Unicar.ViajeEN viaje, UnicarGenNHibernate.EN.Unicar.UsuarioEN usuario)
{
        this.Id = id;


        this.Tipo = tipo;

        this.Viaje = viaje;

        this.Usuario = usuario;
}

public override bool Equals (object obj)
{
        if (obj == null)
                return false;
        AlertaEN t = obj as AlertaEN;
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
