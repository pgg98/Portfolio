
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
 * Clase Valoracion:
 *
 */

namespace UnicarGenNHibernate.CAD.Unicar
{
public partial class ValoracionCAD : BasicCAD, IValoracionCAD
{
public ValoracionCAD() : base ()
{
}

public ValoracionCAD(ISession sessionAux) : base (sessionAux)
{
}



public ValoracionEN ReadOIDDefault (int id
                                    )
{
        ValoracionEN valoracionEN = null;

        try
        {
                SessionInitializeTransaction ();
                valoracionEN = (ValoracionEN)session.Get (typeof(ValoracionEN), id);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ValoracionCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return valoracionEN;
}

public System.Collections.Generic.IList<ValoracionEN> ReadAllDefault (int first, int size)
{
        System.Collections.Generic.IList<ValoracionEN> result = null;
        try
        {
                using (ITransaction tx = session.BeginTransaction ())
                {
                        if (size > 0)
                                result = session.CreateCriteria (typeof(ValoracionEN)).
                                         SetFirstResult (first).SetMaxResults (size).List<ValoracionEN>();
                        else
                                result = session.CreateCriteria (typeof(ValoracionEN)).List<ValoracionEN>();
                }
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ValoracionCAD.", ex);
        }

        return result;
}

// Modify default (Update all attributes of the class)

public void ModifyDefault (ValoracionEN valoracion)
{
        try
        {
                SessionInitializeTransaction ();
                ValoracionEN valoracionEN = (ValoracionEN)session.Load (typeof(ValoracionEN), valoracion.Id);

                valoracionEN.Comentario = valoracion.Comentario;


                valoracionEN.Valoracion = valoracion.Valoracion;



                session.Update (valoracionEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ValoracionCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}


public int Crearvaloracion (ValoracionEN valoracion)
{
        try
        {
                SessionInitializeTransaction ();
                if (valoracion.Viaje != null) {
                        // Argumento OID y no colección.
                        valoracion.Viaje = (UnicarGenNHibernate.EN.Unicar.ViajeEN)session.Load (typeof(UnicarGenNHibernate.EN.Unicar.ViajeEN), valoracion.Viaje.Id);

                        valoracion.Viaje.Valoracion
                        .Add (valoracion);
                }
                if (valoracion.Usuario != null) {
                        // Argumento OID y no colección.
                        valoracion.Usuario = (UnicarGenNHibernate.EN.Unicar.UsuarioEN)session.Load (typeof(UnicarGenNHibernate.EN.Unicar.UsuarioEN), valoracion.Usuario.Nombre_usuario);

                        valoracion.Usuario.Valoracion
                        .Add (valoracion);
                }

                session.Save (valoracion);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ValoracionCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return valoracion.Id;
}

public void Modificarvaloracion (ValoracionEN valoracion)
{
        try
        {
                SessionInitializeTransaction ();
                ValoracionEN valoracionEN = (ValoracionEN)session.Load (typeof(ValoracionEN), valoracion.Id);

                valoracionEN.Comentario = valoracion.Comentario;


                valoracionEN.Valoracion = valoracion.Valoracion;

                session.Update (valoracionEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ValoracionCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}
public void Eliminarvaloracion (int id
                                )
{
        try
        {
                SessionInitializeTransaction ();
                ValoracionEN valoracionEN = (ValoracionEN)session.Load (typeof(ValoracionEN), id);
                session.Delete (valoracionEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ValoracionCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}

public System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ValoracionEN> BuscarValoracionUsuario (string p_nombreUsuario)
{
        System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ValoracionEN> result;
        try
        {
                SessionInitializeTransaction ();
                //String sql = @"FROM ValoracionEN self where select val FROM ValoracionEN as val inner join val.Viaje.Pasajeros pas  where pas.Nombre_usuario = :p_nombreUsuario";
                //IQuery query = session.CreateQuery(sql);
                IQuery query = (IQuery)session.GetNamedQuery ("ValoracionENbuscarValoracionUsuarioHQL");
                query.SetParameter ("p_nombreUsuario", p_nombreUsuario);

                result = query.List<UnicarGenNHibernate.EN.Unicar.ValoracionEN>();
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ValoracionCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return result;
}
//Sin e: ReadOID
//Con e: ValoracionEN
public ValoracionEN ReadOID (int id
                             )
{
        ValoracionEN valoracionEN = null;

        try
        {
                SessionInitializeTransaction ();
                valoracionEN = (ValoracionEN)session.Get (typeof(ValoracionEN), id);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ValoracionCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return valoracionEN;
}

public System.Collections.Generic.IList<ValoracionEN> ReadAll (int first, int size)
{
        System.Collections.Generic.IList<ValoracionEN> result = null;
        try
        {
                SessionInitializeTransaction ();
                if (size > 0)
                        result = session.CreateCriteria (typeof(ValoracionEN)).
                                 SetFirstResult (first).SetMaxResults (size).List<ValoracionEN>();
                else
                        result = session.CreateCriteria (typeof(ValoracionEN)).List<ValoracionEN>();
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ValoracionCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return result;
}
}
}
