using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UnicarAdmin.Models;
using UnicarGenNHibernate.EN.Unicar;

namespace UnicarAdmin.Assemblers
{
    public class AdministradorAssembler
    {
        public AdministradorViewModel ConvertENToModelUI(AdministradorEN en)
        {
            AdministradorViewModel ale = new AdministradorViewModel();

            ale.Nombre_usuario = en.Nombre_usuario;
            ale.Nombre = en.Nombre;
            ale.Apellidos = en.Apellidos;
            ale.Email = en.Email;
            ale.Password = en.Pass;
            ale.Tipo = en.Tipo;

            return ale;
        }

        public IList<AdministradorViewModel> ConvertListENToModel(IList<AdministradorEN> ens)
        {
            IList<AdministradorViewModel> ales = new List<AdministradorViewModel>();
            foreach (AdministradorEN en in ens)
            {
                ales.Add(ConvertENToModelUI(en));
            }
            return ales;
        }
    }
}