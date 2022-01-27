
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



/*PROTECTED REGION ID(usingUnicarGenNHibernate.CP.Unicar_Alerta_new_) ENABLED START*/
//  references to other libraries
using System.Net.Mail;
using System.Net;
/*PROTECTED REGION END*/

namespace UnicarGenNHibernate.CP.Unicar
{
public partial class AlertaCP : BasicCP
{
public UnicarGenNHibernate.EN.Unicar.AlertaEN New_ (UnicarGenNHibernate.Enumerated.Unicar.TipoAlertaEnum p_tipo, int p_viaje, string p_usuario)
{
        /*PROTECTED REGION ID(UnicarGenNHibernate.CP.Unicar_Alerta_new_) ENABLED START*/

        IAlertaCAD alertaCAD = null;
        AlertaCEN alertaCEN = null;
        UsuarioCAD usuarioCAD = new UsuarioCAD (session);
        UsuarioCEN usuarioCEN = new UsuarioCEN (usuarioCAD);
        ViajeCAD viajeCAD = new ViajeCAD (session);
        ViajeCEN viajeCEN = new ViajeCEN (viajeCAD);

        UnicarGenNHibernate.EN.Unicar.AlertaEN result = null;

        try
        {
                SessionInitializeTransaction ();
                alertaCAD = new AlertaCAD (session);
                alertaCEN = new AlertaCEN (alertaCAD);
                UsuarioEN receptor = usuarioCEN.ReadOID (p_usuario);
                ViajeEN viaje = viajeCEN.ReadOID (p_viaje);

                int oid;
                //Initialized AlertaEN
                AlertaEN alertaEN;
                alertaEN = new AlertaEN ();
                alertaEN.Tipo = p_tipo;
                var credentials = new NetworkCredential ("unicarcompany@gmail.com", "grupo2DSM");
                var mail = new MailMessage ();

                if (p_viaje != -1) {
                        alertaEN.Viaje = new UnicarGenNHibernate.EN.Unicar.ViajeEN ();
                        alertaEN.Viaje.Id = p_viaje;
                }

                if (p_usuario != null) {
                        alertaEN.Usuario = new UnicarGenNHibernate.EN.Unicar.UsuarioEN ();
                        alertaEN.Usuario.Nombre_usuario = p_usuario;
                }

                //Hacer los correos con if
                if (p_tipo.Equals (Enumerated.Unicar.TipoAlertaEnum.salida)) { //Salida
                        mail = new MailMessage (){
                                From = new MailAddress ("unicarcompany@gmail.com", "UNICAR WEB"),
                                Subject = "EL VIAJE A LA UNIVERSIDAD ESTA A PUNTO DE COMENZAR - UNICAR",
                                Body = "Hola " + receptor.Nombre + ", el conductor del viaje con destino al punto de recogida esta en camino. Para mas informacion, visite nuestra plataforma. Saludos.",
                                IsBodyHtml = false
                        };

                        mail.To.Add (new MailAddress (receptor.Email));
                }
                else if (p_tipo.Equals (Enumerated.Unicar.TipoAlertaEnum.reservaCon)) { //ReservaCon
                        mail = new MailMessage (){
                                From = new MailAddress ("unicarcompany@gmail.com", "UNICAR WEB"),
                                Subject = "UN NUEVO USUARIO SE HA UNIDO A TU VIAJE - UNICAR",
                                Body = "Hola " + receptor.Nombre + ", un nuevo usuario se ha sumado a tu viaje con destino " + viaje.DireccionLlegada.Direccion + ". Para mas informacion, visite nuestra plataforma. Saludos.",
                                IsBodyHtml = false
                        };

                        mail.To.Add (new MailAddress (receptor.Email));
                }
                else if (p_tipo.Equals (Enumerated.Unicar.TipoAlertaEnum.reservaPas)) { //ReservaPas
                        mail = new MailMessage (){
                                From = new MailAddress ("unicarcompany@gmail.com", "UNICAR WEB"),
                                Subject = "TE HAS UNIDO AL VIAJE " + viaje.DireccionLlegada.Direccion + "- UNICAR",
                                Body = "Hola " + receptor.Nombre + ", ya eres pasajero del viaje con destino " + viaje.DireccionLlegada.Direccion + ". Para mas informacion, visite nuestra plataforma. Saludos.",
                                IsBodyHtml = false
                        };

                        mail.To.Add (new MailAddress (receptor.Email));
                }

                var client = new SmtpClient (){
                        Port = 25,
                        DeliveryMethod = SmtpDeliveryMethod.Network,
                        UseDefaultCredentials = false,
                        Host = "smtp.gmail.com",
                        EnableSsl = true,
                        Credentials = credentials
                };

                client.Send (mail);

                //Call to AlertaCAD

                oid = alertaCAD.New_ (alertaEN);
                result = alertaCAD.ReadOIDDefault (oid);



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
        return result;


        /*PROTECTED REGION END*/
}
}
}
