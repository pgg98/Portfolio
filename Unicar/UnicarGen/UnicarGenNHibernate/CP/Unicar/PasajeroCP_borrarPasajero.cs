
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



/*PROTECTED REGION ID(usingUnicarGenNHibernate.CP.Unicar_Pasajero_borrarPasajero) ENABLED START*/
//  references to other libraries
/*PROTECTED REGION END*/

namespace UnicarGenNHibernate.CP.Unicar
{
public partial class PasajeroCP : BasicCP
{
public void BorrarPasajero (string p_Pasajero_OID)
{
        /*PROTECTED REGION ID(UnicarGenNHibernate.CP.Unicar_Pasajero_borrarPasajero) ENABLED START*/

        IPasajeroCAD pasajeroCAD = null;
        PasajeroCEN pasajeroCEN = null;

        try
        {
                SessionInitializeTransaction ();

                // PasajeroCEN pasa = new PasajeroCEN();
                //  PasajeroEN pes = new PasajeroEN(pasa.ReadOID(id));
                List<int> idViajes = new List<int>();
                List<string> idpas = new List<string>();
                List<int> idAlertas = new List<int>();

                //Lista Viajes del pasajero
                PasajeroCAD pasaCAD = new PasajeroCAD (session);
                PasajeroCEN pasa = new PasajeroCEN (pasaCAD);
                PasajeroEN pes = new PasajeroEN (pasa.ReadOID (id));

                pes.Viajes.ToList ().ForEach (v => idViajes.Add (v.Id));
                //Lista ids del Pasajero, para poder invocar el QuitarPasajero()

                idpas.Add (id);
                //Lista idAlertas para poder borrar todas las alertas del usuario

                pes.Alerta.ToList ().ForEach (v => idAlertas.Add (v.Id));

                //Lista idValoraciones para poder borrar todas las alertas del usuario
                List<int> idValoraciones = new List<int>();
                pes.Valoracion.ToList ().ForEach (v => idValoraciones.Add (v.Id));

                foreach (int david in idViajes) {
                        ViajeCAD viaCAD = new ViajeCAD (session);
                        ViajeCEN vias = new ViajeCEN ();
                        ViajeEN vet = new ViajeEN (viaCAD.ReadOID (david));
                        vias.QuitarPasajero (david, idpas);
                        vet.Plazasocupadas--;
                        //new ViajeEN(vias.ReadOID(david)).Plazasocupadas--;
                }

                //Eliminando las alertas del pasajero
                foreach (int i in idAlertas) {
                        new AlertaCEN ().Destroy (i);
                }

                //Eliminando las valoraciones que ha hecho el pasajero
                foreach (int i in idValoraciones) {
                        new ValoracionCEN ().Eliminarvaloracion (i);
                }



                //Quitando el pasajero de los viajes

                //pasa.Destroy(id);
                pasajeroCAD = new PasajeroCAD (session);
                pasajeroCEN = new  PasajeroCEN (pasajeroCAD);

                pasajeroCAD.BorrarPasajero (id);


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
