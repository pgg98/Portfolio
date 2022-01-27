
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



/*PROTECTED REGION ID(usingUnicarGenNHibernate.CP.Unicar_Conductor_avisarUsuario) ENABLED START*/
//  references to other libraries
/*PROTECTED REGION END*/

namespace UnicarGenNHibernate.CP.Unicar
{
public partial class ConductorCP : BasicCP
{
public void AvisarUsuario (string p_oid, int p_viaje)
{
        /*PROTECTED REGION ID(UnicarGenNHibernate.CP.Unicar_Conductor_avisarUsuario) ENABLED START*/

        IConductorCAD conductorCAD = null;
        ConductorCEN conductorCEN = null;
        ViajeCAD viajeCAD = null;
        ViajeCEN viajeCEN = null;
        AlertaCAD alertaCAD = null;
        AlertaCP alertaCP = null;



        try
        {
                SessionInitializeTransaction ();
                conductorCAD = new ConductorCAD (session);
                conductorCEN = new  ConductorCEN (conductorCAD);
                viajeCAD = new ViajeCAD (session);
                viajeCEN = new ViajeCEN (viajeCAD);
                alertaCAD = new AlertaCAD (session);
                alertaCP = new AlertaCP (session);


                ViajeEN viaje = viajeCAD.ReadOIDDefault (p_viaje);
                foreach (PasajeroEN pasajero in viaje.Pasajeros) {
                        alertaCP.New_ (Enumerated.Unicar.TipoAlertaEnum.salida, p_viaje, pasajero.Nombre_usuario);
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
