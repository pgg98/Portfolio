using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UnicarGenNHibernate.EN.Unicar;
using UnicarAdmin.DefaultConnection;

namespace UnicarAdmin.Assemblers
{
    public class LocalidadAssembler
    {
        public LocalidadViewModel ConvertENToModelUI(LocalidadEN en)
        {
            LocalidadViewModel loc = new LocalidadViewModel();

            loc.id = en.Id;
            loc.nombre = en.Nombre;
            loc.latitud = en.Latitud;
            loc.longitud = en.Longitud;

            return loc;
        }

        public IList<LocalidadViewModel> ConvertListENToModel(IList<LocalidadEN> ens)
        {
            IList<LocalidadViewModel> locs = new List<LocalidadViewModel>();
            foreach(LocalidadEN en in ens)
            {
                locs.Add(ConvertENToModelUI(en));
            }
            return locs;
        }
    }
}