
using System;
// Definición clase VehiculoEN
namespace UnicarGenNHibernate.EN.Unicar
{
public partial class VehiculoEN
{
/**
 *	Atributo matricula
 */
private string matricula;



/**
 *	Atributo marca
 */
private string marca;



/**
 *	Atributo modelo
 */
private string modelo;



/**
 *	Atributo conductor
 */
private UnicarGenNHibernate.EN.Unicar.ConductorEN conductor;



/**
 *	Atributo viaje
 */
private System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> viaje;






public virtual string Matricula {
        get { return matricula; } set { matricula = value;  }
}



public virtual string Marca {
        get { return marca; } set { marca = value;  }
}



public virtual string Modelo {
        get { return modelo; } set { modelo = value;  }
}



public virtual UnicarGenNHibernate.EN.Unicar.ConductorEN Conductor {
        get { return conductor; } set { conductor = value;  }
}



public virtual System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> Viaje {
        get { return viaje; } set { viaje = value;  }
}





public VehiculoEN()
{
        viaje = new System.Collections.Generic.List<UnicarGenNHibernate.EN.Unicar.ViajeEN>();
}



public VehiculoEN(string matricula, string marca, string modelo, UnicarGenNHibernate.EN.Unicar.ConductorEN conductor, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> viaje
                  )
{
        this.init (Matricula, marca, modelo, conductor, viaje);
}


public VehiculoEN(VehiculoEN vehiculo)
{
        this.init (Matricula, vehiculo.Marca, vehiculo.Modelo, vehiculo.Conductor, vehiculo.Viaje);
}

private void init (string matricula
                   , string marca, string modelo, UnicarGenNHibernate.EN.Unicar.ConductorEN conductor, System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> viaje)
{
        this.Matricula = matricula;


        this.Marca = marca;

        this.Modelo = modelo;

        this.Conductor = conductor;

        this.Viaje = viaje;
}

public override bool Equals (object obj)
{
        if (obj == null)
                return false;
        VehiculoEN t = obj as VehiculoEN;
        if (t == null)
                return false;
        if (Matricula.Equals (t.Matricula))
                return true;
        else
                return false;
}

public override int GetHashCode ()
{
        int hash = 13;

        hash += this.Matricula.GetHashCode ();
        return hash;
}
}
}
