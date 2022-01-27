
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;


namespace UnicarAdmin.Models
{

    public class AlertaViewModel
    {


        [ScaffoldColumn(false)]
        [Display(Prompt = "ID", Description = "ID", Name = "ID")]
        public int Id { get; set; }

        [Display(Prompt = "Tipo de Alerta", Description = "Tipo de Alerta", Name = "Tipo")]
        [Required(ErrorMessage = "Debe introducir el tipo de alerta.")]
        public UnicarGenNHibernate.Enumerated.Unicar.TipoAlertaEnum Tipo { get; set; }

        [Display(Prompt = "Usuario", Description = "Usuario", Name = "Usuario")]
        [Required(ErrorMessage = "Debe introducir un usuario.")]
        public String Usuario { get; set; }

        [Display(Prompt = "Viaje", Description = "Viaje", Name = "Viaje")]
        [Required(ErrorMessage = "Debe introducir la marca de un viaje.")]
        public int Viaje { get; set; }
    }

}
