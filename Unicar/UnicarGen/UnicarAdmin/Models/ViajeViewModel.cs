using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using UnicarGenNHibernate.EN.Unicar;

namespace UnicarAdmin.DefaultConnection
{
    public class ViajeViewModel
    {

        [Display(Prompt = "", Description = "", Name = "ID")]
        [Required(ErrorMessage = "")]
        public int Id {get; set;}

        [Display(Prompt = "Número de plazas", Description = "Número de plazas", Name = "Plazas Totales")]
        [Range(minimum: 0, maximum: 10, ErrorMessage = "Las plazas tienen que ser mayor que 0 y menor que 10")]
        [Required(ErrorMessage = "Debe introducir un número de plazas.")]
        public int Plazas { get; set; }

        [Display(Prompt = "Número de plazas ocupadas", Description = "Número de plazas ocupadas", Name = "Plazas Ocupadas")]
        [Range(minimum: 0, maximum:10, ErrorMessage = "Las plazas ocupadas tienen que ser mayor que 0 y menor que 10")]
        [Required(ErrorMessage = "Debe introducir un número de plazas ocupadas por conductor y acompañantes.")]
        public int PlazasOcupadas { get; set; }

        [Display(Prompt = "Precio", Description = "Precio del viaje", Name = "Precio")]
        [Required(ErrorMessage = "Debe introducir el precio del viaje.")]
        [DataType (DataType.Currency)]
        [Range(minimum:0, maximum:100000000, ErrorMessage = "El precio tiene que ser mayor que 0")]
        public double Precio { get; set; }

        [Display(Prompt = "Fecha de salida", Description = "Fecha de salida", Name = "Fecha de Salida")]
        [DataType(DataType.Date)]
        [DisplayFormat(DataFormatString = "{0:yyyy-MM-dd}", ApplyFormatInEditMode =true)]
        [Required(ErrorMessage = "Debe introducir la fecha de salida")]
        public DateTime? FechaSalida { get; set; }

        [Display(Prompt = "Hora de salida", Description = "Hora de salida", Name = "Hora de Salida")]
        [DataType(DataType.Time)]
        [DisplayFormat(DataFormatString = "{0:HH:mm}", ApplyFormatInEditMode = true)]
        [Required(ErrorMessage = "Debe introducir la hora de salida")]
        public DateTime? HoraSalida { get; set; }

        [Display(Prompt = "Fehca de llegada", Description = "Fecha de llegada", Name = "Fecha de Llegada")]
        [DataType(DataType.Date)]
        [DisplayFormat(DataFormatString = "{0:yyyy-MM-dd}", ApplyFormatInEditMode = true)]
        [Required(ErrorMessage = "Debe introducir la fecha y la hora de llegada.")]
        public DateTime? FechaLlegada { get; set; }

        [Display(Prompt = "Hora de llegada", Description = "Hora de llegada", Name = "Hora de llegada")]
        [DataType(DataType.Time)]
        [DisplayFormat(DataFormatString = "{0:HH:mm}", ApplyFormatInEditMode = true)]
        [Required(ErrorMessage = "Debe introducir la hora de llegada")]
        public DateTime? HoraLlegada { get; set; }

        [Display(Prompt = "Dirección de llegada", Description = "Dirección de llegada", Name = "Dirección de llegada")]
        [Required(ErrorMessage = "Debe introducir la dirección de llegada.")]
        public String DireccionLlegada { get; set; }

        [ScaffoldColumn(false)]
        [Display(Prompt = "Localidad de llegada", Description = "Localidad de llegada", Name = "Localidad de llegada")]
        [Required(ErrorMessage = "Debe seleccionar una localidad de llegada.")]
        public int LocalidadLlegada { get; set; }

        [Display(Prompt = "Localidad de llegada", Description = "Localidad de llegada", Name = "Localidad de llegada")]
        public String LocalidadLlegadaNombre { get; set; }

        [Display(Prompt = "Dirección de salida", Description = "Dirección de salida", Name = "Dirección de salida")]
        [Required(ErrorMessage = "Debe introducir la dirección de salida.")]
        public String DireccionSalida { get; set; }

        [ScaffoldColumn(false)]
        [Display(Prompt = "Localidad de salida", Description = "Localidad de Salida", Name = "Localidad de Salida")]
        [Required(ErrorMessage = "Debe seleccionar una localidad de salida.")]
        public int LocalidadSalida { get; set; }

        [Display(Prompt = "Localidad de salida", Description = "Localidad de Salida", Name = "Localidad de Salida")]
        public String LocalidadSalidaNombre { get; set; }

        [Display(Prompt = "Conductor", Description = "Conductor", Name = "Conductor")]
        [Required(ErrorMessage = "Debe seleccionar un conductor.")]
        public String Conductor { get; set; }

        [Display(Prompt = "Vehiculo", Description = "Vehiculo", Name = "Vehiculo")]
        [Required(ErrorMessage = "Debe introducir un vehiculo.")]
        public String Vehiculo { get; set; }

        [Display(Prompt = "Modelo vehiculo", Description = "Modelo vehiculo", Name = "Modelo vehiculo")]
        [Required(ErrorMessage = "Debe introducir un vehiculo.")]
        public String Modelo { get; set; }
    }
}