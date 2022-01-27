
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
 * Clase Administrador:
 *
 */

namespace UnicarGenNHibernate.CAD.Unicar
{
public partial class AdministradorCAD : BasicCAD, IAdministradorCAD
{
public AdministradorCAD() : base ()
{
}

public AdministradorCAD(ISession sessionAux) : base (sessionAux)
{
}



public AdministradorEN ReadOIDDefault (string nombre_usuario
                                       )
{
        AdministradorEN administradorEN = null;

        try
        {
                SessionInitializeTransaction ();
                administradorEN = (AdministradorEN)session.Get (typeof(AdministradorEN), nombre_usuario);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in AdministradorCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return administradorEN;
}

public System.Collections.Generic.IList<AdministradorEN> ReadAllDefault (int first, int size)
{
        System.Collections.Generic.IList<AdministradorEN> result = null;
        try
        {
                using (ITransaction tx = session.BeginTransaction ())
                {
                        if (size > 0)
                                result = session.CreateCriteria (typeof(AdministradorEN)).
                                         SetFirstResult (first).SetMaxResults (size).List<AdministradorEN>();
                        else
                                result = session.CreateCriteria (typeof(AdministradorEN)).List<AdministradorEN>();
                }
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in AdministradorCAD.", ex);
        }

        return result;
}

// Modify default (Update all attributes of the class)

public void ModifyDefault (AdministradorEN administrador)
{
        try
        {
                SessionInitializeTransaction ();
                AdministradorEN administradorEN = (AdministradorEN)session.Load (typeof(AdministradorEN), administrador.Nombre_usuario);
                session.Update (administradorEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in AdministradorCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}


public string New_ (AdministradorEN administrador)
{
        try
        {
                SessionInitializeTransaction ();

                session.Save (administrador);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in AdministradorCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return administrador.Nombre_usuario;
}

public void Modify (AdministradorEN administrador)
{
        try
        {
                SessionInitializeTransaction ();
                AdministradorEN administradorEN = (AdministradorEN)session.Load (typeof(AdministradorEN), administrador.Nombre_usuario);

                administradorEN.Nombre = administrador.Nombre;


                administradorEN.Apellidos = administrador.Apellidos;


                administradorEN.Email = administrador.Email;


                administradorEN.Pass = administrador.Pass;


                administradorEN.ValoracionMedia = administrador.ValoracionMedia;


                administradorEN.Tipo = administrador.Tipo;

                session.Update (administradorEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in AdministradorCAD.", ex);
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
                AdministradorEN administradorEN = (AdministradorEN)session.Load (typeof(AdministradorEN), nombre_usuario);
                session.Delete (administradorEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in AdministradorCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}

//Sin e: ReadOID
//Con e: AdministradorEN
public AdministradorEN ReadOID (string nombre_usuario
                                )
{
        AdministradorEN administradorEN = null;

        try
        {
                SessionInitializeTransaction ();
                administradorEN = (AdministradorEN)session.Get (typeof(AdministradorEN), nombre_usuario);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in AdministradorCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return administradorEN;
}

public System.Collections.Generic.IList<AdministradorEN> ReadAll (int first, int size)
{
        System.Collections.Generic.IList<AdministradorEN> result = null;
        try
        {
                SessionInitializeTransaction ();
                if (size > 0)
                        result = session.CreateCriteria (typeof(AdministradorEN)).
                                 SetFirstResult (first).SetMaxResults (size).List<AdministradorEN>();
                else
                        result = session.CreateCriteria (typeof(AdministradorEN)).List<AdministradorEN>();
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in AdministradorCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return result;
}
}
}
