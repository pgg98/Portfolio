using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UnicarGenNHibernate.EN.Unicar;
using UnicarAdmin.Models;

namespace UnicarAdmin.Assemblers
{
    public class AlertaAssembler
    {
        public AlertaViewModel ConvertENToModelUI(AlertaEN en)
        {
            AlertaViewModel ale = new AlertaViewModel();

            ale.Id = en.Id;
            ale.Tipo = en.Tipo;
            ale.Usuario = en.Usuario.Nombre_usuario;
            ale.Viaje = en.Viaje.Id;

            return ale;
        }

        public IList<AlertaViewModel> ConvertListENToModel(IList<AlertaEN> ens)
        {
            IList<AlertaViewModel> ales = new List<AlertaViewModel>();
            foreach (AlertaEN en in ens)
            {
                ales.Add(ConvertENToModelUI(en));
            }
            return ales;
        }
    }
}