using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace UnicarAdmin.Models
{
    public class DireccionViewModel
    {
        [ScaffoldColumn(false)]
        public int id { get; set; }

        [Display(Prompt = "Direccion completa", Description = "Direccion completa", Name = "Dirección")]
        [Required(ErrorMessage = "Debe introducir una direccion válida.")]
        public String Direccion { get; set; }

        [ScaffoldColumn(false)]
        [Display(Prompt = "Localidad", Description = "Localidad", Name = "Localidad")]
        [Required(ErrorMessage = "Debe seleccionar una localidad.")]
        public int Localidad { get; set; }

        [Display(Prompt = "Localidad", Description = "Localidad", Name = "Localidad")]
        public String LocalidadNombre { get; set; }

    }
}