
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
public partial class VehiculoCP : BasicCP
{
public VehiculoCP() : base ()
{
}

public VehiculoCP(ISession sessionAux)
        : base (sessionAux)
{
}
}
}
