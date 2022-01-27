
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
 * Clase Pasajero:
 *
 */

namespace UnicarGenNHibernate.CAD.Unicar
{
public partial class PasajeroCAD : BasicCAD, IPasajeroCAD
{
public PasajeroCAD() : base ()
{
}

public PasajeroCAD(ISession sessionAux) : base (sessionAux)
{
}



public PasajeroEN ReadOIDDefault (string nombre_usuario
                                  )
{
        PasajeroEN pasajeroEN = null;

        try
        {
                SessionInitializeTransaction ();
                pasajeroEN = (PasajeroEN)session.Get (typeof(PasajeroEN), nombre_usuario);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in PasajeroCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return pasajeroEN;
}

public System.Collections.Generic.IList<PasajeroEN> ReadAllDefault (int first, int size)
{
        System.Collections.Generic.IList<PasajeroEN> result = null;
        try
        {
                using (ITransaction tx = session.BeginTransaction ())
                {
                        if (size > 0)
                                result = session.CreateCriteria (typeof(PasajeroEN)).
                                         SetFirstResult (first).SetMaxResults (size).List<PasajeroEN>();
                        else
                                result = session.CreateCriteria (typeof(PasajeroEN)).List<PasajeroEN>();
                }
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in PasajeroCAD.", ex);
        }

        return result;
}

// Modify default (Update all attributes of the class)

public void ModifyDefault (PasajeroEN pasajero)
{
        try
        {
                SessionInitializeTransaction ();
                PasajeroEN pasajeroEN = (PasajeroEN)session.Load (typeof(PasajeroEN), pasajero.Nombre_usuario);

                session.Update (pasajeroEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in PasajeroCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}


public string New_ (PasajeroEN pasajero)
{
        try
        {
                SessionInitializeTransaction ();

                session.Save (pasajero);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in PasajeroCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return pasajero.Nombre_usuario;
}

public void Modify (PasajeroEN pasajero)
{
        try
        {
                SessionInitializeTransaction ();
                PasajeroEN pasajeroEN = (PasajeroEN)session.Load (typeof(PasajeroEN), pasajero.Nombre_usuario);

                pasajeroEN.Nombre = pasajero.Nombre;


                pasajeroEN.Apellidos = pasajero.Apellidos;


                pasajeroEN.Email = pasajero.Email;


                pasajeroEN.Pass = pasajero.Pass;


                pasajeroEN.ValoracionMedia = pasajero.ValoracionMedia;


                pasajeroEN.Tipo = pasajero.Tipo;

                session.Update (pasajeroEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in PasajeroCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}
public void Destroy (string nombre_usuario
                     )
{
        try
        {
                SessionInitializeTransaction ();
                PasajeroEN pasajeroEN = (PasajeroEN)session.Load (typeof(PasajeroEN), nombre_usuario);
                session.Delete (pasajeroEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in PasajeroCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}

public void AnyadirViaje (string p_Pasajero_OID, System.Collections.Generic.IList<int> p_viajes_OIDs)
{
        UnicarGenNHibernate.EN.Unicar.PasajeroEN pasajeroEN = null;
        try
        {
                SessionInitializeTransaction ();
                pasajeroEN = (PasajeroEN)session.Load (typeof(PasajeroEN), p_Pasajero_OID);
                UnicarGenNHibernate.EN.Unicar.ViajeEN viajesENAux = null;
                if (pasajeroEN.Viajes == null) {
                        pasajeroEN.Viajes = new System.Collections.Generic.List<UnicarGenNHibernate.EN.Unicar.ViajeEN>();
                }

                foreach (int item in p_viajes_OIDs) {
                        viajesENAux = new UnicarGenNHibernate.EN.Unicar.ViajeEN ();
                        viajesENAux = (UnicarGenNHibernate.EN.Unicar.ViajeEN)session.Load (typeof(UnicarGenNHibernate.EN.Unicar.ViajeEN), item);
                        viajesENAux.Pasajeros.Add (pasajeroEN);

                        pasajeroEN.Viajes.Add (viajesENAux);
                }


                session.Update (pasajeroEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in PasajeroCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}

//Sin e: ReadOID
//Con e: PasajeroEN
public PasajeroEN ReadOID (string nombre_usuario
                           )
{
        PasajeroEN pasajeroEN = null;

        try
        {
                SessionInitializeTransaction ();
                pasajeroEN = (PasajeroEN)session.Get (typeof(PasajeroEN), nombre_usuario);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in PasajeroCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return pasajeroEN;
}

public System.Collections.Generic.IList<PasajeroEN> ReadAll (int first, int size)
{
        System.Collections.Generic.IList<PasajeroEN> result = null;
        try
        {
                SessionInitializeTransaction ();
                if (size > 0)
                        result = session.CreateCriteria (typeof(PasajeroEN)).
                                 SetFirstResult (first).SetMaxResults (size).List<PasajeroEN>();
                else
                        result = session.CreateCriteria (typeof(PasajeroEN)).List<PasajeroEN>();
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in PasajeroCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return result;
}

public void BorrarPasajero (string nombre_usuario
                            )
{
        try
        {
                SessionInitializeTransaction ();
                PasajeroEN pasajeroEN = (PasajeroEN)session.Load (typeof(PasajeroEN), nombre_usuario);
                session.Delete (pasajeroEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in PasajeroCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}
}
}
