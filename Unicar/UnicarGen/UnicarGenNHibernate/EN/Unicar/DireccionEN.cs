
using System;
// Definición clase DireccionEN
namespace UnicarGenNHibernate.EN.Unicar
{
public partial class DireccionEN
{
/**
 *	Atributo viajesLlegada
 */
private System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> viajesLlegada;



/**
 *	Atributo viajeSalida
 */
private System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> viajeSalida;



/**
 *	Atributo id
 */
private int id;



/**
 *	Atributo localidad
 */
private UnicarGenNHibernate.EN.Unicar.LocalidadEN localidad;



/**
 *	Atributo direccion
 */
private string direccion;






public virtual System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> ViajesLlegada {
        get { return viajesLlegada; } set { viajesLlegada = value;  }
}



public virtual System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> ViajeSalida {
        get { return viajeSalida; } set { viajeSalida = value;  }
}



public virtual int Id {
        get { return id; } set { id = value;  }
}



public virtual UnicarGenNHibernate.EN.Unicar.LocalidadEN Localidad {
        get { return localidad; } set { localidad = value;  }
}



public virtual string Direccion {
        get { return direccion; } set { direccion = value;  }
}





public DireccionEN()
{
        viajesLlegada = new System.Collections.Generic.List<UnicarGenNHibernate.EN.Unicar.ViajeEN>();
        viajeSalida = new System.Collections.Generic.List<UnicarGenNHibernate.EN.Unicar.ViajeEN>();
}



public DireccionEN(int id, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> viajesLlegada, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> viajeSalida, UnicarGenNHibernate.EN.Unicar.LocalidadEN localidad, string direccion
                   )
{
        this.init (Id, viajesLlegada, viajeSalida, localidad, direccion);
}


public DireccionEN(DireccionEN direccion)
{
        this.init (Id, direccion.ViajesLlegada, direccion.ViajeSalida, direccion.Localidad, direccion.Direccion);
}

private void init (int id
                   , System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> viajesLlegada, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> viajeSalida, UnicarGenNHibernate.EN.Unicar.LocalidadEN localidad, string direccion)
{
        this.Id = id;


        this.ViajesLlegada = viajesLlegada;

        this.ViajeSalida = viajeSalida;

        this.Localidad = localidad;

        this.Direccion = direccion;
}

public override bool Equals (object obj)
{
        if (obj == null)
                return false;
        DireccionEN t = obj as DireccionEN;
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
