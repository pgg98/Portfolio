
using System;
using System.Text;
using System.Collections.Generic;
using NHibernate;
using NHibernate.Cfg;
using NHibernate.Criterion;
using NHibernate.Exceptions;
using UnicarGenNHibernate.Exceptions;
using UnicarGenNHibernate.EN.Unicar;
using UnicarGenNHibernate.CAD.Unicar;


/*PROTECTED REGION ID(usingUnicarGenNHibernate.CEN.Unicar_Viaje_reservarViaje) ENABLED START*/
//  references to other libraries
/*PROTECTED REGION END*/

namespace UnicarGenNHibernate.CEN.Unicar
{
public partial class ViajeCEN
{
public void ReservarViaje (int p_oid)
{
            /*PROTECTED REGION ID(UnicarGenNHibernate.CEN.Unicar_Viaje_reservarViaje) ENABLED START*/

            ViajeEN viaje = _IViajeCAD.ReadOIDDefault(p_oid);

            if (viaje.Plazas > viaje.Plazasocupadas)
            {
                viaje.Plazasocupadas++;
                _IViajeCAD.ModifyDefault(viaje);
                //¿COMO HACEMOS FEEDBACK AL USUARIO¿            
            }
            else
            {
                throw new ModelException("No se puede reservar, no hay plazas disponibles.");
            }




        /*PROTECTED REGION END*/
}
}
}
