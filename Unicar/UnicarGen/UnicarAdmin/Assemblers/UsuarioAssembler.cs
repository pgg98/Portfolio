using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UnicarAdmin.Models;
using UnicarGenNHibernate.EN.Unicar;

namespace UnicarAdmin.Assemblers
{
    public class UsuarioAssembler
    {
        public UsuarioViewModel ConvertENToModelUI(UsuarioEN en)
        {
            UsuarioViewModel usua = new UsuarioViewModel();

            usua.Nombre_usuario = en.Nombre_usuario;
            usua.Nombre = en.Nombre;
            usua.Apellidos = en.Apellidos;
            usua.Email = en.Email;
            usua.Password = en.Pass;
            usua.ValoracionMedia = en.ValoracionMedia;
            usua.Tipo = en.Tipo;

            return usua;
        }

        public IList<UsuarioViewModel> ConvertListENToModel(IList<UsuarioEN> ens)
        {
            IList<UsuarioViewModel> usuas = new List<UsuarioViewModel>();
            foreach (var en in ens)
            {
                usuas.Add(ConvertENToModelUI(en));
            }
            return usuas;
        }
    }
}