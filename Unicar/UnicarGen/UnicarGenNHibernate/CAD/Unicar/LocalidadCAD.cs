
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
 * Clase Localidad:
 *
 */

namespace UnicarGenNHibernate.CAD.Unicar
{
public partial class LocalidadCAD : BasicCAD, ILocalidadCAD
{
public LocalidadCAD() : base ()
{
}

public LocalidadCAD(ISession sessionAux) : base (sessionAux)
{
}



public LocalidadEN ReadOIDDefault (int id
                                   )
{
        LocalidadEN localidadEN = null;

        try
        {
                SessionInitializeTransaction ();
                localidadEN = (LocalidadEN)session.Get (typeof(LocalidadEN), id);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in LocalidadCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return localidadEN;
}

public System.Collections.Generic.IList<LocalidadEN> ReadAllDefault (int first, int size)
{
        System.Collections.Generic.IList<LocalidadEN> result = null;
        try
        {
                using (ITransaction tx = session.BeginTransaction ())
                {
                        if (size > 0)
                                result = session.CreateCriteria (typeof(LocalidadEN)).
                                         SetFirstResult (first).SetMaxResults (size).List<LocalidadEN>();
                        else
                                result = session.CreateCriteria (typeof(LocalidadEN)).List<LocalidadEN>();
                }
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in LocalidadCAD.", ex);
        }

        return result;
}

// Modify default (Update all attributes of the class)

public void ModifyDefault (LocalidadEN localidad)
{
        try
        {
                SessionInitializeTransaction ();
                LocalidadEN localidadEN = (LocalidadEN)session.Load (typeof(LocalidadEN), localidad.Id);

                localidadEN.Nombre = localidad.Nombre;



                localidadEN.Latitud = localidad.Latitud;


                localidadEN.Longitud = localidad.Longitud;

                session.Update (localidadEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in LocalidadCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}


public int New_ (LocalidadEN localidad)
{
        try
        {
                SessionInitializeTransaction ();

                session.Save (localidad);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in LocalidadCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return localidad.Id;
}

public void Modify (LocalidadEN localidad)
{
        try
        {
                SessionInitializeTransaction ();
                LocalidadEN localidadEN = (LocalidadEN)session.Load (typeof(LocalidadEN), localidad.Id);

                localidadEN.Nombre = localidad.Nombre;


                localidadEN.Latitud = localidad.Latitud;


                localidadEN.Longitud = localidad.Longitud;

                session.Update (localidadEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in LocalidadCAD.", ex);
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
                LocalidadEN localidadEN = (LocalidadEN)session.Load (typeof(LocalidadEN), id);
                session.Delete (localidadEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in LocalidadCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}

//Sin e: ReadOID
//Con e: LocalidadEN
public LocalidadEN ReadOID (int id
                            )
{
        LocalidadEN localidadEN = null;

        try
        {
                SessionInitializeTransaction ();
                localidadEN = (LocalidadEN)session.Get (typeof(LocalidadEN), id);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in LocalidadCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return localidadEN;
}

public System.Collections.Generic.IList<LocalidadEN> ReadAll (int first, int size)
{
        System.Collections.Generic.IList<LocalidadEN> result = null;
        try
        {
                SessionInitializeTransaction ();
                if (size > 0)
                        result = session.CreateCriteria (typeof(LocalidadEN)).
                                 SetFirstResult (first).SetMaxResults (size).List<LocalidadEN>();
                else
                        result = session.CreateCriteria (typeof(LocalidadEN)).List<LocalidadEN>();
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in LocalidadCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return result;
}
}
}
