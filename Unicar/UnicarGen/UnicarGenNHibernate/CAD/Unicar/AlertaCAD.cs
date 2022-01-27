
using System;
using System.Text;
using UnicarGenNHibernate.CEN.Unicar;
using NHibernate;
using NHibernate.Cfg;
using NHibernate.Criterion;
using NHibernate.Exceptions;
using UnicarGenNHibernate.EN.Unicar;
using UnicarGenNHibernate.Exceptions;


/*
 * Clase Alerta:
 *
 */

namespace UnicarGenNHibernate.CAD.Unicar
{
public partial class AlertaCAD : BasicCAD, IAlertaCAD
{
public AlertaCAD() : base ()
{
}

public AlertaCAD(ISession sessionAux) : base (sessionAux)
{
}



public AlertaEN ReadOIDDefault (int id
                                )
{
        AlertaEN alertaEN = null;

        try
        {
                SessionInitializeTransaction ();
                alertaEN = (AlertaEN)session.Get (typeof(AlertaEN), id);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in AlertaCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return alertaEN;
}

public System.Collections.Generic.IList<AlertaEN> ReadAllDefault (int first, int size)
{
        System.Collections.Generic.IList<AlertaEN> result = null;
        try
        {
                using (ITransaction tx = session.BeginTransaction ())
                {
                        if (size > 0)
                                result = session.CreateCriteria (typeof(AlertaEN)).
                                         SetFirstResult (first).SetMaxResults (size).List<AlertaEN>();
                        else
                                result = session.CreateCriteria (typeof(AlertaEN)).List<AlertaEN>();
                }
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in AlertaCAD.", ex);
        }

        return result;
}

// Modify default (Update all attributes of the class)

public void ModifyDefault (AlertaEN alerta)
{
        try
        {
                SessionInitializeTransaction ();
                AlertaEN alertaEN = (AlertaEN)session.Load (typeof(AlertaEN), alerta.Id);

                alertaEN.Tipo = alerta.Tipo;



                session.Update (alertaEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in AlertaCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}


public int New_ (AlertaEN alerta)
{
        try
        {
                SessionInitializeTransaction ();
                if (alerta.Viaje != null) {
                        // Argumento OID y no colección.
                        alerta.Viaje = (UnicarGenNHibernate.EN.Unicar.ViajeEN)session.Load (typeof(UnicarGenNHibernate.EN.Unicar.ViajeEN), alerta.Viaje.Id);

                        alerta.Viaje.Alerta
                        .Add (alerta);
                }
                if (alerta.Usuario != null) {
                        // Argumento OID y no colección.
                        alerta.Usuario = (UnicarGenNHibernate.EN.Unicar.UsuarioEN)session.Load (typeof(UnicarGenNHibernate.EN.Unicar.UsuarioEN), alerta.Usuario.Nombre_usuario);

                        alerta.Usuario.Alerta
                        .Add (alerta);
                }

                session.Save (alerta);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in AlertaCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return alerta.Id;
}

public void Modify (AlertaEN alerta)
{
        try
        {
                SessionInitializeTransaction ();
                AlertaEN alertaEN = (AlertaEN)session.Load (typeof(AlertaEN), alerta.Id);

                alertaEN.Tipo = alerta.Tipo;

                session.Update (alertaEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in AlertaCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}
public void Destroy (int id
                     )
{
        try
        {
                SessionInitializeTransaction ();
                AlertaEN alertaEN = (AlertaEN)session.Load (typeof(AlertaEN), id);
                session.Delete (alertaEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in AlertaCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}

//Sin e: ReadOID
//Con e: AlertaEN
public AlertaEN ReadOID (int id
                         )
{
        AlertaEN alertaEN = null;

        try
        {
                SessionInitializeTransaction ();
                alertaEN = (AlertaEN)session.Get (typeof(AlertaEN), id);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in AlertaCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return alertaEN;
}

public System.Collections.Generic.IList<AlertaEN> ReadAll (int first, int size)
{
        System.Collections.Generic.IList<AlertaEN> result = null;
        try
        {
                SessionInitializeTransaction ();
                if (size > 0)
                        result = session.CreateCriteria (typeof(AlertaEN)).
                                 SetFirstResult (first).SetMaxResults (size).List<AlertaEN>();
                else
                        result = session.CreateCriteria (typeof(AlertaEN)).List<AlertaEN>();
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in AlertaCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return result;
}
}
}
