using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UnicarGenNHibernate.EN.Unicar;
using UnicarAdmin.Models;

namespace UnicarAdmin.Assemblers
{
    public class DireccionAssembler
    {
        public DireccionViewModel ConvertENToModelUI(DireccionEN en)
        {
            DireccionViewModel dir = new DireccionViewModel();

            dir.id = en.Id;
            dir.Direccion = en.Direccion;
            dir.LocalidadNombre = en.Localidad.Nombre;

            return dir;
        }

        public IList<DireccionViewModel> ConvertListENToModel(IList<DireccionEN> ens)
        {
            IList<DireccionViewModel> dirs = new List<DireccionViewModel>();
            foreach (var en in ens)
            {
                dirs.Add(ConvertENToModelUI(en));
            }
            return dirs;
        }
    }
}