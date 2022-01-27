
using System;
using System.Text;
using System.Collections.Generic;
using NHibernate;
using NHibernate.Cfg;
using NHibernate.Criterion;
using UnicarGenNHibernate.Exceptions;
using UnicarGenNHibernate.EN.Unicar;
using UnicarGenNHibernate.CAD.Unicar;
using UnicarGenNHibernate.CEN.Unicar;



namespace UnicarGenNHibernate.CP.Unicar
{
public partial class AlertaCP : BasicCP
{
public AlertaCP() : base ()
{
}

public AlertaCP(ISession sessionAux)
        : base (sessionAux)
{
}
}
}
