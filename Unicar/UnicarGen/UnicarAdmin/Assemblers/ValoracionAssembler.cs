using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UnicarGenNHibernate.EN.Unicar;
using UnicarAdmin.Models;


namespace UnicarAdmin.Assemblers
{
    public class ValoracionAssembler
    {
        public ValoracionViewModel ConvertENToModelUI(ValoracionEN en)
        {
            ValoracionViewModel val = new ValoracionViewModel();

            val.id = en.Id;
            val.Comentario = en.Comentario;
            val.Valoracion = en.Valoracion;
            val.Viaje = en.Viaje.Id;
            val.Pasajero = en.Usuario.Nombre_usuario;

            return val;
        }

        public IList<ValoracionViewModel> ConvertListENToModel(IList<ValoracionEN> ens)
        {
            IList<ValoracionViewModel> vars = new List<ValoracionViewModel>();
            foreach (var en in ens)
            {
                vars.Add(ConvertENToModelUI(en));
            }
            return vars;
        }
    }
}