
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
 * Clase Vehiculo:
 *
 */

namespace UnicarGenNHibernate.CAD.Unicar
{
public partial class VehiculoCAD : BasicCAD, IVehiculoCAD
{
public VehiculoCAD() : base ()
{
}

public VehiculoCAD(ISession sessionAux) : base (sessionAux)
{
}



public VehiculoEN ReadOIDDefault (string matricula
                                  )
{
        VehiculoEN vehiculoEN = null;

        try
        {
                SessionInitializeTransaction ();
                vehiculoEN = (VehiculoEN)session.Get (typeof(VehiculoEN), matricula);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in VehiculoCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return vehiculoEN;
}

public System.Collections.Generic.IList<VehiculoEN> ReadAllDefault (int first, int size)
{
        System.Collections.Generic.IList<VehiculoEN> result = null;
        try
        {
                using (ITransaction tx = session.BeginTransaction ())
                {
                        if (size > 0)
                                result = session.CreateCriteria (typeof(VehiculoEN)).
                                         SetFirstResult (first).SetMaxResults (size).List<VehiculoEN>();
                        else
                                result = session.CreateCriteria (typeof(VehiculoEN)).List<VehiculoEN>();
                }
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in VehiculoCAD.", ex);
        }

        return result;
}

// Modify default (Update all attributes of the class)

public void ModifyDefault (VehiculoEN vehiculo)
{
        try
        {
                SessionInitializeTransaction ();
                VehiculoEN vehiculoEN = (VehiculoEN)session.Load (typeof(VehiculoEN), vehiculo.Matricula);

                vehiculoEN.Marca = vehiculo.Marca;


                vehiculoEN.Modelo = vehiculo.Modelo;



                session.Update (vehiculoEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in VehiculoCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}


public string New_ (VehiculoEN vehiculo)
{
        try
        {
                SessionInitializeTransaction ();
                if (vehiculo.Conductor != null) {
                        // Argumento OID y no colección.
                        vehiculo.Conductor = (UnicarGenNHibernate.EN.Unicar.ConductorEN)session.Load (typeof(UnicarGenNHibernate.EN.Unicar.ConductorEN), vehiculo.Conductor.Nombre_usuario);

                        vehiculo.Conductor.Vehiculo
                        .Add (vehiculo);
                }

                session.Save (vehiculo);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in VehiculoCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return vehiculo.Matricula;
}

public void Modify (VehiculoEN vehiculo)
{
        try
        {
                SessionInitializeTransaction ();
                VehiculoEN vehiculoEN = (VehiculoEN)session.Load (typeof(VehiculoEN), vehiculo.Matricula);

                vehiculoEN.Marca = vehiculo.Marca;


                vehiculoEN.Modelo = vehiculo.Modelo;

                session.Update (vehiculoEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in VehiculoCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}
public void Destroy (string matricula
                     )
{
        try
        {
                SessionInitializeTransaction ();
                VehiculoEN vehiculoEN = (VehiculoEN)session.Load (typeof(VehiculoEN), matricula);
                session.Delete (vehiculoEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in VehiculoCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}

//Sin e: ReadOID
//Con e: VehiculoEN
public VehiculoEN ReadOID (string matricula
                           )
{
        VehiculoEN vehiculoEN = null;

        try
        {
                SessionInitializeTransaction ();
                vehiculoEN = (VehiculoEN)session.Get (typeof(VehiculoEN), matricula);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in VehiculoCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return vehiculoEN;
}

public System.Collections.Generic.IList<VehiculoEN> ReadAll (int first, int size)
{
        System.Collections.Generic.IList<VehiculoEN> result = null;
        try
        {
                SessionInitializeTransaction ();
                if (size > 0)
                        result = session.CreateCriteria (typeof(VehiculoEN)).
                                 SetFirstResult (first).SetMaxResults (size).List<VehiculoEN>();
                else
                        result = session.CreateCriteria (typeof(VehiculoEN)).List<VehiculoEN>();
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in VehiculoCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return result;
}

public void QuitarViaje (string p_Vehiculo_OID, System.Collections.Generic.IList<int> p_viaje_OIDs)
{
        try
        {
                SessionInitializeTransaction ();
                UnicarGenNHibernate.EN.Unicar.VehiculoEN vehiculoEN = null;
                vehiculoEN = (VehiculoEN)session.Load (typeof(VehiculoEN), p_Vehiculo_OID);

                UnicarGenNHibernate.EN.Unicar.ViajeEN viajeENAux = null;
                if (vehiculoEN.Viaje != null) {
                        foreach (int item in p_viaje_OIDs) {
                                viajeENAux = (UnicarGenNHibernate.EN.Unicar.ViajeEN)session.Load (typeof(UnicarGenNHibernate.EN.Unicar.ViajeEN), item);
                                if (vehiculoEN.Viaje.Contains (viajeENAux) == true) {
                                        vehiculoEN.Viaje.Remove (viajeENAux);
                                        viajeENAux.Vehiculo = null;
                                }
                                else
                                        throw new ModelException ("The identifier " + item + " in p_viaje_OIDs you are trying to unrelationer, doesn't exist in VehiculoEN");
                        }
                }

                session.Update (vehiculoEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in VehiculoCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}
}
}
