
using System;
using UnicarGenNHibernate.EN.Unicar;

namespace UnicarGenNHibernate.CAD.Unicar
{
public partial interface IVehiculoCAD
{
VehiculoEN ReadOIDDefault (string matricula
                           );

void ModifyDefault (VehiculoEN vehiculo);

System.Collections.Generic.IList<VehiculoEN> ReadAllDefault (int first, int size);



string New_ (VehiculoEN vehiculo);

void Modify (VehiculoEN vehiculo);


void Destroy (string matricula
              );


VehiculoEN ReadOID (string matricula
                    );


System.Collections.Generic.IList<VehiculoEN> ReadAll (int first, int size);


void QuitarViaje (string p_Vehiculo_OID, System.Collections.Generic.IList<int> p_viaje_OIDs);
}
}
