using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UnicarAdmin.Models;
using UnicarGenNHibernate.EN.Unicar;

namespace UnicarAdmin.Assemblers
{
    public class PasajeroAssembler
    {
        public PasajeroViewModel ConvertENToModelUI(PasajeroEN en)
        {
            PasajeroViewModel pasa = new PasajeroViewModel();

            pasa.Nombre_usuario = en.Nombre_usuario;
            pasa.Nombre = en.Nombre;
            pasa.Apellidos = en.Apellidos;
            pasa.Email = en.Email;
            pasa.Password = en.Pass;
            pasa.ValoracionMedia = en.ValoracionMedia;
            pasa.Tipo = en.Tipo;
            pasa.NumeroViajes = en.Viajes.Count;

            return pasa;
        }

        public IList<PasajeroViewModel> ConvertListENToModel(IList<PasajeroEN> ens)
        {
            IList<PasajeroViewModel> pasas = new List<PasajeroViewModel>();
            foreach (var en in ens)
            {
                pasas.Add(ConvertENToModelUI(en));
            }
            return pasas;
        }
    }
}