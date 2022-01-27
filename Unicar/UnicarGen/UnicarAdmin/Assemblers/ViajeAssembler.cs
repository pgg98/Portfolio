using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UnicarGenNHibernate.EN.Unicar;
using UnicarAdmin.DefaultConnection;

namespace UnicarAdmin.Assemblers
{
    public class ViajeAssembler
    {
        public ViajeViewModel ConvertENToModelUI(ViajeEN en) {
            ViajeViewModel viaje = new ViajeViewModel();
            viaje.Id = en.Id;
            viaje.Plazas = en.Plazas;
            viaje.PlazasOcupadas = en.Plazasocupadas;
            viaje.Precio = en.Precio;
            viaje.FechaSalida = en.Fechasalida;
            viaje.HoraSalida = en.Horasalida;
            viaje.FechaLlegada = en.Fechallegada;
            viaje.HoraLlegada = en.Horallegada;
            viaje.DireccionLlegada = en.DireccionLlegada.Direccion;
            viaje.LocalidadLlegada = en.DireccionLlegada.Localidad.Id;
            viaje.DireccionSalida = en.DireccionSalida.Direccion;
            viaje.LocalidadSalida = en.DireccionSalida.Localidad.Id;
            viaje.Conductor = en.Conductor.Nombre_usuario;
            viaje.Vehiculo = en.Vehiculo.Matricula;
            viaje.Modelo = en.Vehiculo.Modelo;
            viaje.LocalidadSalidaNombre = en.DireccionSalida.Localidad.Nombre;
            viaje.LocalidadLlegadaNombre = en.DireccionLlegada.Localidad.Nombre;

            return viaje;
        }

        public IList<ViajeViewModel> ConvertListENToModel(IList<ViajeEN> ens) {

            IList<ViajeViewModel> viajes = new List<ViajeViewModel>();

            foreach (ViajeEN en in ens) {

                viajes.Add(ConvertENToModelUI(en));
            
            }

            return viajes;
        }
    }
}