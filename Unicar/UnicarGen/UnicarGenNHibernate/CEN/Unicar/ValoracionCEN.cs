

using System;
using System.Text;
using System.Collections.Generic;
using Newtonsoft.Json;
using NHibernate;
using NHibernate.Cfg;
using NHibernate.Criterion;
using NHibernate.Exceptions;
using UnicarGenNHibernate.Exceptions;

using UnicarGenNHibernate.EN.Unicar;
using UnicarGenNHibernate.CAD.Unicar;


namespace UnicarGenNHibernate.CEN.Unicar
{
/*
 *      Definition of the class ValoracionCEN
 *
 */
public partial class ValoracionCEN
{
private IValoracionCAD _IValoracionCAD;

public ValoracionCEN()
{
        this._IValoracionCAD = new ValoracionCAD ();
}

public ValoracionCEN(IValoracionCAD _IValoracionCAD)
{
        this._IValoracionCAD = _IValoracionCAD;
}

public IValoracionCAD get_IValoracionCAD ()
{
        return this._IValoracionCAD;
}

public int Crearvaloracion (string p_comentario, int p_valoracion, int p_viaje, string p_usuario)
{
        ValoracionEN valoracionEN = null;
        int oid;

        //Initialized ValoracionEN
        valoracionEN = new ValoracionEN ();
        valoracionEN.Comentario = p_comentario;

        valoracionEN.Valoracion = p_valoracion;


        if (p_viaje != -1) {
                // El argumento p_viaje -> Property viaje es oid = false
                // Lista de oids id
                valoracionEN.Viaje = new UnicarGenNHibernate.EN.Unicar.ViajeEN ();
                valoracionEN.Viaje.Id = p_viaje;
        }


        if (p_usuario != null) {
                // El argumento p_usuario -> Property usuario es oid = false
                // Lista de oids id
                valoracionEN.Usuario = new UnicarGenNHibernate.EN.Unicar.UsuarioEN ();
                valoracionEN.Usuario.Nombre_usuario = p_usuario;
        }

        //Call to ValoracionCAD

        oid = _IValoracionCAD.Crearvaloracion (valoracionEN);
        return oid;
}

public void Modificarvaloracion (int p_Valoracion_OID, string p_comentario, int p_valoracion)
{
        ValoracionEN valoracionEN = null;

        //Initialized ValoracionEN
        valoracionEN = new ValoracionEN ();
        valoracionEN.Id = p_Valoracion_OID;
        valoracionEN.Comentario = p_comentario;
        valoracionEN.Valoracion = p_valoracion;
        //Call to ValoracionCAD

        _IValoracionCAD.Modificarvaloracion (valoracionEN);
}

public void Eliminarvaloracion (int id
                                )
{
        _IValoracionCAD.Eliminarvaloracion (id);
}

public System.Collections.Generic.IList<UnicarGenNHibernate.EN.Unicar.ValoracionEN> BuscarValoracionUsuario (string p_nombreUsuario)
{
        return _IValoracionCAD.BuscarValoracionUsuario (p_nombreUsuario);
}
public ValoracionEN ReadOID (int id
                             )
{
        ValoracionEN valoracionEN = null;

        valoracionEN = _IValoracionCAD.ReadOID (id);
        return valoracionEN;
}

public System.Collections.Generic.IList<ValoracionEN> ReadAll (int first, int size)
{
        System.Collections.Generic.IList<ValoracionEN> list = null;

        list = _IValoracionCAD.ReadAll (first, size);
        return list;
}
}
}
