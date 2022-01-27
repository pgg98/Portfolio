
using System;
using System.Text;

using NHibernate;
using NHibernate.Cfg;
using NHibernate.Criterion;
using NHibernate.Exceptions;
using System.Collections.Generic;
using UnicarGenNHibernate.EN.Unicar;
using UnicarGenNHibernate.CAD.Unicar;
using UnicarGenNHibernate.CEN.Unicar;



/*PROTECTED REGION ID(usingUnicarGenNHibernate.CP.Unicar_Viaje_reservarViaje) ENABLED START*/
/*PROTECTED REGION END*/

namespace UnicarGenNHibernate.CP.Unicar
{
public partial class ViajeCP : BasicCP
{
public void ReservarViaje (int p_oid, string p_idpasajero)
{
        /*PROTECTED REGION ID(UnicarGenNHibernate.CP.Unicar_Viaje_reservarViaje) ENABLED START*/

        IViajeCAD viajeCAD = null;
        ViajeCEN viajeCEN = null;
        PasajeroCAD pasajeroCAD = null;
        PasajeroCEN pasajeroCEN = null;
        AlertaCAD alertaCAD = null;
        AlertaCP alertaCP = null;



        try
        {
                SessionInitializeTransaction ();
                viajeCAD = new ViajeCAD (session);
                viajeCEN = new  ViajeCEN (viajeCAD);
                pasajeroCAD = new PasajeroCAD (session);
                pasajeroCEN = new PasajeroCEN (pasajeroCAD);
                alertaCAD = new AlertaCAD (session);
                alertaCP = new AlertaCP (session);

                // Write here your custom transaction ...

                ViajeEN viaje = viajeCAD.ReadOIDDefault (p_oid);

                if (viaje.Plazas > viaje.Plazasocupadas) {
                        viaje.Plazasocupadas++;
                        viajeCAD.ModifyDefault (viaje);
                        viajeCEN.AnyadirPasajero (p_oid, new List<string> { p_idpasajero });
                        //   pasajeroCEN.AnyadirViaje (p_idpasajero, new List<int> { p_oid });
                        alertaCP.New_ (Enumerated.Unicar.TipoAlertaEnum.reservaPas, viaje.Id, p_idpasajero);
                        alertaCP.New_ (Enumerated.Unicar.TipoAlertaEnum.reservaCon, viaje.Id, viaje.Conductor.Nombre_usuario);
                }


                SessionCommit ();
        }
        catch (Exception ex)
        {
                SessionRollBack ();
                throw ex;
        }
        finally
        {
                SessionClose ();
        }

        /*PROTECTED REGION END*/
}
}
}
