
using System;
// Definición clase ValoracionEN
namespace UnicarGenNHibernate.EN.Unicar
{
public partial class ValoracionEN
{
/**
 *	Atributo id
 */
private int id;



/**
 *	Atributo comentario
 */
private string comentario;



/**
 *	Atributo valoracion
 */
private int valoracion;



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



public virtual string Comentario {
        get { return comentario; } set { comentario = value;  }
}



public virtual int Valoracion {
        get { return valoracion; } set { valoracion = value;  }
}



public virtual UnicarGenNHibernate.EN.Unicar.ViajeEN Viaje {
        get { return viaje; } set { viaje = value;  }
}



public virtual UnicarGenNHibernate.EN.Unicar.UsuarioEN Usuario {
        get { return usuario; } set { usuario = value;  }
}





public ValoracionEN()
{
}



public ValoracionEN(int id, string comentario, int valoracion, UnicarGenNHibernate.EN.Unicar.ViajeEN viaje, UnicarGenNHibernate.EN.Unicar.UsuarioEN usuario
                    )
{
        this.init (Id, comentario, valoracion, viaje, usuario);
}


public ValoracionEN(ValoracionEN valoracion)
{
        this.init (Id, valoracion.Comentario, valoracion.Valoracion, valoracion.Viaje, valoracion.Usuario);
}

private void init (int id
                   , string comentario, int valoracion, UnicarGenNHibernate.EN.Unicar.ViajeEN viaje, UnicarGenNHibernate.EN.Unicar.UsuarioEN usuario)
{
        this.Id = id;


        this.Comentario = comentario;

        this.Valoracion = valoracion;

        this.Viaje = viaje;

        this.Usuario = usuario;
}

public override bool Equals (object obj)
{
        if (obj == null)
                return false;
        ValoracionEN t = obj as ValoracionEN;
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
