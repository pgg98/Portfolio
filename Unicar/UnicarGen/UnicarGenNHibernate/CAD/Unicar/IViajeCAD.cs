
using System;
using UnicarGenNHibernate.EN.Unicar;

namespace UnicarGenNHibernate.CAD.Unicar
{
public partial interface IViajeCAD
{
ViajeEN ReadOIDDefault (int id
                        );

void ModifyDefault (ViajeEN viaje);

System.Collections.Generic.IList<ViajeEN> ReadAllDefault (int first, int size);



int New_ (ViajeEN viaje);

void Modify (ViajeEN viaje);


ViajeEN ReadOID (int id
                 );


System.Collections.Generic.IList<ViajeEN> ReadAll (int first, int size);



System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> BuscarViajeDireccion (string p_NombreLocalidad);


System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> BuscarViajeConductor (string p_nombreUsuario);


System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> BuscarViajePorPasajero (string p_pasajero);


void QuitarPasajero (int p_Viaje_OID, System.Collections.Generic.IList<string> p_pasajeros_OIDs);

void Destroy (int id
              );


void AnyadirPasajero (int p_Viaje_OID, System.Collections.Generic.IList<string> p_pasajeros_OIDs);
}
}
