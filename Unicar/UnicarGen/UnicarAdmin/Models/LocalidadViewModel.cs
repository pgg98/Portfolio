using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace UnicarAdmin.DefaultConnection
{
    public class LocalidadViewModel
    {

        [ScaffoldColumn(false)]
        public int id { get; set; }

        [Display(Prompt = "Nombre de la localidad", Description = "Nombre de la localidad", Name = "Nombre")]
        [Required(ErrorMessage = "Debe introducir un nombre para la localidad.")]
        [StringLength(maximumLength: 100, ErrorMessage = "El nombre de la localidad no puede tener mas de 20 caracteres")]
        public string nombre { get; set; }

        [Display(Prompt = "Latitud de la localidad", Description = "Latitud de la localidad", Name = "Latitud")]
        [Required(ErrorMessage = "Debe introducir latitud valido.")]

        public Double latitud { get; set; }

        [Display(Prompt = "Longitud de la localidad", Description = "Longitud de la localidad", Name = "Longitud")]
        [Required(ErrorMessage = "Debe introducir longitud valido.")]

        public Double longitud { get; set; }

    }
}