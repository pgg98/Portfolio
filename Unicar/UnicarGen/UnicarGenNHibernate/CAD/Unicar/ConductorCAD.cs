
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
 * Clase Conductor:
 *
 */

namespace UnicarGenNHibernate.CAD.Unicar
{
public partial class ConductorCAD : BasicCAD, IConductorCAD
{
public ConductorCAD() : base ()
{
}

public ConductorCAD(ISession sessionAux) : base (sessionAux)
{
}



public ConductorEN ReadOIDDefault (string nombre_usuario
                                   )
{
        ConductorEN conductorEN = null;

        try
        {
                SessionInitializeTransaction ();
                conductorEN = (ConductorEN)session.Get (typeof(ConductorEN), nombre_usuario);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ConductorCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return conductorEN;
}

public System.Collections.Generic.IList<ConductorEN> ReadAllDefault (int first, int size)
{
        System.Collections.Generic.IList<ConductorEN> result = null;
        try
        {
                using (ITransaction tx = session.BeginTransaction ())
                {
                        if (size > 0)
                                result = session.CreateCriteria (typeof(ConductorEN)).
                                         SetFirstResult (first).SetMaxResults (size).List<ConductorEN>();
                        else
                                result = session.CreateCriteria (typeof(ConductorEN)).List<ConductorEN>();
                }
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ConductorCAD.", ex);
        }

        return result;
}

// Modify default (Update all attributes of the class)

public void ModifyDefault (ConductorEN conductor)
{
        try
        {
                SessionInitializeTransaction ();
                ConductorEN conductorEN = (ConductorEN)session.Load (typeof(ConductorEN), conductor.Nombre_usuario);



                conductorEN.Restriccion = conductor.Restriccion;

                session.Update (conductorEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ConductorCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}


public string New_ (ConductorEN conductor)
{
        try
        {
                SessionInitializeTransaction ();

                session.Save (conductor);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ConductorCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return conductor.Nombre_usuario;
}

public void Modify (ConductorEN conductor)
{
        try
        {
                SessionInitializeTransaction ();
                ConductorEN conductorEN = (ConductorEN)session.Load (typeof(ConductorEN), conductor.Nombre_usuario);

                conductorEN.Nombre = conductor.Nombre;


                conductorEN.Apellidos = conductor.Apellidos;


                conductorEN.Email = conductor.Email;


                conductorEN.Pass = conductor.Pass;


                conductorEN.ValoracionMedia = conductor.ValoracionMedia;


                conductorEN.Tipo = conductor.Tipo;


                conductorEN.Restriccion = conductor.Restriccion;

                session.Update (conductorEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ConductorCAD.", ex);
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
                ConductorEN conductorEN = (ConductorEN)session.Load (typeof(ConductorEN), nombre_usuario);
                session.Delete (conductorEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ConductorCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}

//Sin e: ReadOID
//Con e: ConductorEN
public ConductorEN ReadOID (string nombre_usuario
                            )
{
        ConductorEN conductorEN = null;

        try
        {
                SessionInitializeTransaction ();
                conductorEN = (ConductorEN)session.Get (typeof(ConductorEN), nombre_usuario);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ConductorCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return conductorEN;
}

public System.Collections.Generic.IList<ConductorEN> ReadAll (int first, int size)
{
        System.Collections.Generic.IList<ConductorEN> result = null;
        try
        {
                SessionInitializeTransaction ();
                if (size > 0)
                        result = session.CreateCriteria (typeof(ConductorEN)).
                                 SetFirstResult (first).SetMaxResults (size).List<ConductorEN>();
                else
                        result = session.CreateCriteria (typeof(ConductorEN)).List<ConductorEN>();
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ConductorCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return result;
}
}
}
