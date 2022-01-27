
using System;
using UnicarGenNHibernate.EN.Unicar;

namespace UnicarGenNHibernate.CAD.Unicar
{
public partial interface IAlertaCAD
{
AlertaEN ReadOIDDefault (int id
                         );

void ModifyDefault (AlertaEN alerta);

System.Collections.Generic.IList<AlertaEN> ReadAllDefault (int first, int size);



int New_ (AlertaEN alerta);

void Modify (AlertaEN alerta);


void Destroy (int id
              );


AlertaEN ReadOID (int id
                  );


System.Collections.Generic.IList<AlertaEN> ReadAll (int first, int size);
}
}
