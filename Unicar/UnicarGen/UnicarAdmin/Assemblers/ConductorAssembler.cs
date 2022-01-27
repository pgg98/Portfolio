using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UnicarAdmin.Models;
using UnicarGenNHibernate.EN.Unicar;

namespace UnicarAdmin.Assemblers
{
    public class ConductorAssembler
    {
        public ConductorViewModel ConvertENToModelUI(ConductorEN en)
        {
            ConductorViewModel con = new ConductorViewModel();

            con.Nombre_usuario = en.Nombre_usuario;
            con.Nombre = en.Nombre;
            con.Apellidos = en.Apellidos;
            con.Email = en.Email;
            con.Password = en.Pass;
            con.ValoracionMedia = en.ValoracionMedia;
            con.Tipo = en.Tipo;
            con.Restriccion = en.Restriccion;

            return con;
        }

        public IList<ConductorViewModel> ConvertListENToModel(IList<ConductorEN> ens)
        {
            IList<ConductorViewModel> dirs = new List<ConductorViewModel>();
            foreach (var en in ens)
            {
                dirs.Add(ConvertENToModelUI(en));
            }
            return dirs;
        }
    }
}