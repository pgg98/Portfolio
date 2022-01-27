
using System;
using UnicarGenNHibernate.EN.Unicar;

namespace UnicarGenNHibernate.CAD.Unicar
{
public partial interface IPasajeroCAD
{
PasajeroEN ReadOIDDefault (string nombre_usuario
                           );

void ModifyDefault (PasajeroEN pasajero);

System.Collections.Generic.IList<PasajeroEN> ReadAllDefault (int first, int size);



string New_ (PasajeroEN pasajero);

void Modify (PasajeroEN pasajero);


void Destroy (string nombre_usuario
              );


void AnyadirViaje (string p_Pasajero_OID, System.Collections.Generic.IList<int> p_viajes_OIDs);

PasajeroEN ReadOID (string nombre_usuario
                    );


System.Collections.Generic.IList<PasajeroEN> ReadAll (int first, int size);


void BorrarPasajero (string nombre_usuario
                     );
}
}
