

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
 *      Definition of the class AlertaCEN
 *
 */
public partial class AlertaCEN
{
private IAlertaCAD _IAlertaCAD;

public AlertaCEN()
{
        this._IAlertaCAD = new AlertaCAD ();
}

public AlertaCEN(IAlertaCAD _IAlertaCAD)
{
        this._IAlertaCAD = _IAlertaCAD;
}

public IAlertaCAD get_IAlertaCAD ()
{
        return this._IAlertaCAD;
}

public void Modify (int p_Alerta_OID, UnicarGenNHibernate.Enumerated.Unicar.TipoAlertaEnum p_tipo)
{
        AlertaEN alertaEN = null;

        //Initialized AlertaEN
        alertaEN = new AlertaEN ();
        alertaEN.Id = p_Alerta_OID;
        alertaEN.Tipo = p_tipo;
        //Call to AlertaCAD

        _IAlertaCAD.Modify (alertaEN);
}

public void Destroy (int id
                     )
{
        _IAlertaCAD.Destroy (id);
}

public AlertaEN ReadOID (int id
                         )
{
        AlertaEN alertaEN = null;

        alertaEN = _IAlertaCAD.ReadOID (id);
        return alertaEN;
}

public System.Collections.Generic.IList<AlertaEN> ReadAll (int first, int size)
{
        System.Collections.Generic.IList<AlertaEN> list = null;

        list = _IAlertaCAD.ReadAll (first, size);
        return list;
}
}
}
