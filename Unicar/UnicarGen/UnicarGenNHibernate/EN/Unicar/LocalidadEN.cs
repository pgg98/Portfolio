
using System;
// Definición clase LocalidadEN
namespace UnicarGenNHibernate.EN.Unicar
{
public partial class LocalidadEN
{
/**
 *	Atributo nombre
 */
private string nombre;



/**
 *	Atributo direccion
 */
private System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.DireccionEN> direccion;



/**
 *	Atributo latitud
 */
private double latitud;



/**
 *	Atributo longitud
 */
private double longitud;



/**
 *	Atributo id
 */
private int id;






public virtual string Nombre {
        get { return nombre; } set { nombre = value;  }
}



public virtual System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.DireccionEN> Direccion {
        get { return direccion; } set { direccion = value;  }
}



public virtual double Latitud {
        get { return latitud; } set { latitud = value;  }
}



public virtual double Longitud {
        get { return longitud; } set { longitud = value;  }
}



public virtual int Id {
        get { return id; } set { id = value;  }
}





public LocalidadEN()
{
        direccion = new System.Collections.Generic.List<UnicarGenNHibernate.EN.Unicar.DireccionEN>();
}



public LocalidadEN(int id, string nombre, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.DireccionEN> direccion, double latitud, double longitud
                   )
{
        this.init (Id, nombre, direccion, latitud, longitud);
}


public LocalidadEN(LocalidadEN localidad)
{
        this.init (Id, localidad.Nombre, localidad.Direccion, localidad.Latitud, localidad.Longitud);
}

private void init (int id
                   , string nombre, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.DireccionEN> direccion, double latitud, double longitud)
{
        this.Id = id;


        this.Nombre = nombre;

        this.Direccion = direccion;

        this.Latitud = latitud;

        this.Longitud = longitud;
}

public override bool Equals (object obj)
{
        if (obj == null)
                return false;
        LocalidadEN t = obj as LocalidadEN;
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
