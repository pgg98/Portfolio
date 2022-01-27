using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UnicarGenNHibernate.EN.Unicar;
using UnicarAdmin.DefaultConnection;

namespace UnicarAdmin.Assemblers
{
    public class VehiculoAssembler
    {
        public VehiculoViewModel ConvertENToModelUI(VehiculoEN en)
        {
            VehiculoViewModel vei = new VehiculoViewModel();

            vei.Matricula = en.Matricula;
            vei.Marca = en.Marca;
            vei.Modelo = en.Modelo;
            vei.Conductor = en.Conductor.Nombre_usuario;

            return vei;
        }

        public IList<VehiculoViewModel> ConvertListENToModel(IList<VehiculoEN> ens)
        {
            IList<VehiculoViewModel> veis = new List<VehiculoViewModel>();
            foreach(VehiculoEN en in ens)
            {
                veis.Add(ConvertENToModelUI(en));
            }
            return veis;
        }
    }
}