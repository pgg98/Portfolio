
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
 * Clase Viaje:
 *
 */

namespace UnicarGenNHibernate.CAD.Unicar
{
public partial class ViajeCAD : BasicCAD, IViajeCAD
{
public ViajeCAD() : base ()
{
}

public ViajeCAD(ISession sessionAux) : base (sessionAux)
{
}



public ViajeEN ReadOIDDefault (int id
                               )
{
        ViajeEN viajeEN = null;

        try
        {
                SessionInitializeTransaction ();
                viajeEN = (ViajeEN)session.Get (typeof(ViajeEN), id);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ViajeCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return viajeEN;
}

public System.Collections.Generic.IList<ViajeEN> ReadAllDefault (int first, int size)
{
        System.Collections.Generic.IList<ViajeEN> result = null;
        try
        {
                using (ITransaction tx = session.BeginTransaction ())
                {
                        if (size > 0)
                                result = session.CreateCriteria (typeof(ViajeEN)).
                                         SetFirstResult (first).SetMaxResults (size).List<ViajeEN>();
                        else
                                result = session.CreateCriteria (typeof(ViajeEN)).List<ViajeEN>();
                }
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ViajeCAD.", ex);
        }

        return result;
}

// Modify default (Update all attributes of the class)

public void ModifyDefault (ViajeEN viaje)
{
        try
        {
                SessionInitializeTransaction ();
                ViajeEN viajeEN = (ViajeEN)session.Load (typeof(ViajeEN), viaje.Id);

                viajeEN.Fechasalida = viaje.Fechasalida;


                viajeEN.Fechallegada = viaje.Fechallegada;




                viajeEN.Plazas = viaje.Plazas;


                viajeEN.Precio = viaje.Precio;







                viajeEN.Plazasocupadas = viaje.Plazasocupadas;


                viajeEN.Horasalida = viaje.Horasalida;


                viajeEN.Horallegada = viaje.Horallegada;

                session.Update (viajeEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ViajeCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}


public int New_ (ViajeEN viaje)
{
        try
        {
                SessionInitializeTransaction ();
                if (viaje.Conductor != null) {
                        // Argumento OID y no colección.
                        viaje.Conductor = (UnicarGenNHibernate.EN.Unicar.ConductorEN)session.Load (typeof(UnicarGenNHibernate.EN.Unicar.ConductorEN), viaje.Conductor.Nombre_usuario);

                        viaje.Conductor.Viaje
                        .Add (viaje);
                }
                if (viaje.Vehiculo != null) {
                        // Argumento OID y no colección.
                        viaje.Vehiculo = (UnicarGenNHibernate.EN.Unicar.VehiculoEN)session.Load (typeof(UnicarGenNHibernate.EN.Unicar.VehiculoEN), viaje.Vehiculo.Matricula);

                        viaje.Vehiculo.Viaje
                        .Add (viaje);
                }
                if (viaje.DireccionLlegada != null) {
                        // Argumento OID y no colección.
                        viaje.DireccionLlegada = (UnicarGenNHibernate.EN.Unicar.DireccionEN)session.Load (typeof(UnicarGenNHibernate.EN.Unicar.DireccionEN), viaje.DireccionLlegada.Id);

                        viaje.DireccionLlegada.ViajesLlegada
                        .Add (viaje);
                }
                if (viaje.DireccionSalida != null) {
                        // Argumento OID y no colección.
                        viaje.DireccionSalida = (UnicarGenNHibernate.EN.Unicar.DireccionEN)session.Load (typeof(UnicarGenNHibernate.EN.Unicar.DireccionEN), viaje.DireccionSalida.Id);

                        viaje.DireccionSalida.ViajeSalida
                        .Add (viaje);
                }

                session.Save (viaje);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ViajeCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return viaje.Id;
}

public void Modify (ViajeEN viaje)
{
        try
        {
                SessionInitializeTransaction ();
                ViajeEN viajeEN = (ViajeEN)session.Load (typeof(ViajeEN), viaje.Id);

                viajeEN.Fechasalida = viaje.Fechasalida;


                viajeEN.Fechallegada = viaje.Fechallegada;


                viajeEN.Plazas = viaje.Plazas;


                viajeEN.Precio = viaje.Precio;


                viajeEN.Plazasocupadas = viaje.Plazasocupadas;


                viajeEN.Horasalida = viaje.Horasalida;


                viajeEN.Horallegada = viaje.Horallegada;

                session.Update (viajeEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ViajeCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}
//Sin e: ReadOID
//Con e: ViajeEN
public ViajeEN ReadOID (int id
                        )
{
        ViajeEN viajeEN = null;

        try
        {
                SessionInitializeTransaction ();
                viajeEN = (ViajeEN)session.Get (typeof(ViajeEN), id);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ViajeCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return viajeEN;
}

public System.Collections.Generic.IList<ViajeEN> ReadAll (int first, int size)
{
        System.Collections.Generic.IList<ViajeEN> result = null;
        try
        {
                SessionInitializeTransaction ();
                if (size > 0)
                        result = session.CreateCriteria (typeof(ViajeEN)).
                                 SetFirstResult (first).SetMaxResults (size).List<ViajeEN>();
                else
                        result = session.CreateCriteria (typeof(ViajeEN)).List<ViajeEN>();
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ViajeCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return result;
}

public System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> BuscarViajeDireccion (string p_NombreLocalidad)
{
        System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> result;
        try
        {
                SessionInitializeTransaction ();
                //String sql = @"FROM ViajeEN self where select viajes FROM ViajeEN as viajes where viajes.DireccionSalida.Localidad.Nombre =:p_NombreLocalidad";
                //IQuery query = session.CreateQuery(sql);
                IQuery query = (IQuery)session.GetNamedQuery ("ViajeENbuscarViajeDireccionHQL");
                query.SetParameter ("p_NombreLocalidad", p_NombreLocalidad);

                result = query.List<UnicarGenNHibernate.EN.Unicar.ViajeEN>();
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ViajeCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return result;
}
public System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> BuscarViajeConductor (string p_nombreUsuario)
{
        System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> result;
        try
        {
                SessionInitializeTransaction ();
                //String sql = @"FROM ViajeEN self where select via FROM ViajeEN as via  where via.Conductor.Nombre_usuario = :p_nombreUsuario";
                //IQuery query = session.CreateQuery(sql);
                IQuery query = (IQuery)session.GetNamedQuery ("ViajeENbuscarViajeConductorHQL");
                query.SetParameter ("p_nombreUsuario", p_nombreUsuario);

                result = query.List<UnicarGenNHibernate.EN.Unicar.ViajeEN>();
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ViajeCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return result;
}
public System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> BuscarViajePorPasajero (string p_pasajero)
{
        System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ViajeEN> result;
        try
        {
                SessionInitializeTransaction ();
                //String sql = @"FROM ViajeEN self where SELECT viaje FROM ViajeEN as viaje INNER JOIN viaje.Pasajeros as pasa WHERE pasa.Nombre_usuario=:p_pasajero";
                //IQuery query = session.CreateQuery(sql);
                IQuery query = (IQuery)session.GetNamedQuery ("ViajeENbuscarViajePorPasajeroHQL");
                query.SetParameter ("p_pasajero", p_pasajero);

                result = query.List<UnicarGenNHibernate.EN.Unicar.ViajeEN>();
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ViajeCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }

        return result;
}
public void QuitarPasajero (int p_Viaje_OID, System.Collections.Generic.IList<string> p_pasajeros_OIDs)
{
        try
        {
                SessionInitializeTransaction ();
                UnicarGenNHibernate.EN.Unicar.ViajeEN viajeEN = null;
                viajeEN = (ViajeEN)session.Load (typeof(ViajeEN), p_Viaje_OID);

                UnicarGenNHibernate.EN.Unicar.PasajeroEN pasajerosENAux = null;
                if (viajeEN.Pasajeros != null) {
                        foreach (string item in p_pasajeros_OIDs) {
                                pasajerosENAux = (UnicarGenNHibernate.EN.Unicar.PasajeroEN)session.Load (typeof(UnicarGenNHibernate.EN.Unicar.PasajeroEN), item);
                                if (viajeEN.Pasajeros.Contains (pasajerosENAux) == true) {
                                        viajeEN.Pasajeros.Remove (pasajerosENAux);
                                        pasajerosENAux.Viajes.Remove (viajeEN);
                                }
                                else
                                        throw new ModelException ("The identifier " + item + " in p_pasajeros_OIDs you are trying to unrelationer, doesn't exist in ViajeEN");
                        }
                }

                session.Update (viajeEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ViajeCAD.", ex);
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
                ViajeEN viajeEN = (ViajeEN)session.Load (typeof(ViajeEN), id);
                session.Delete (viajeEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ViajeCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}

public void AnyadirPasajero (int p_Viaje_OID, System.Collections.Generic.IList<string> p_pasajeros_OIDs)
{
        UnicarGenNHibernate.EN.Unicar.ViajeEN viajeEN = null;
        try
        {
                SessionInitializeTransaction ();
                viajeEN = (ViajeEN)session.Load (typeof(ViajeEN), p_Viaje_OID);
                UnicarGenNHibernate.EN.Unicar.PasajeroEN pasajerosENAux = null;
                if (viajeEN.Pasajeros == null) {
                        viajeEN.Pasajeros = new System.Collections.Generic.List<UnicarGenNHibernate.EN.Unicar.PasajeroEN>();
                }

                foreach (string item in p_pasajeros_OIDs) {
                        pasajerosENAux = new UnicarGenNHibernate.EN.Unicar.PasajeroEN ();
                        pasajerosENAux = (UnicarGenNHibernate.EN.Unicar.PasajeroEN)session.Load (typeof(UnicarGenNHibernate.EN.Unicar.PasajeroEN), item);
                        pasajerosENAux.Viajes.Add (viajeEN);

                        viajeEN.Pasajeros.Add (pasajerosENAux);
                }


                session.Update (viajeEN);
                SessionCommit ();
        }

        catch (Exception ex) {
                SessionRollBack ();
                if (ex is UnicarGenNHibernate.Exceptions.ModelException)
                        throw ex;
                throw new UnicarGenNHibernate.Exceptions.DataLayerException ("Error in ViajeCAD.", ex);
        }


        finally
        {
                SessionClose ();
        }
}
}
}
