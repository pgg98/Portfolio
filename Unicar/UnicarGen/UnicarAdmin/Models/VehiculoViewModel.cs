using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace UnicarAdmin.DefaultConnection
{
    public class VehiculoViewModel
    {
        [ScaffoldColumn (false)]
        [Display(Prompt = "Matricula del coche", Description = "Matricula del coche", Name = "Matricula")]
        [Required(ErrorMessage = "Debe introducir una matricula de un coche.")]
        [StringLength(maximumLength: 10, ErrorMessage = "La matricula no puede tener mas de 10 caracteres")]
        public string Matricula { get; set; }

        [Display(Prompt = "Marca del coche", Description = "Marca del coche", Name = "Marca")]
        [Required(ErrorMessage = "Debe introducir la marca de un coche.")]
        [StringLength(maximumLength: 20, ErrorMessage = "La matricula no puede tener mas de 20 caracteres")]
        public string Marca { get; set; }

        [Display(Prompt = "Modelo del coche", Description = "Modelo del coche", Name = "Modelo")]
        [Required(ErrorMessage = "Debe introducir el modelo de un coche.")]
        [StringLength(maximumLength: 20, ErrorMessage = "La matricula no puede tener mas de 20 caracteres")]
        public string Modelo { get; set; }

        [Display(Prompt = "Conductor vehículo", Description = "Conductor vehículo", Name = "Conductor")]
        [Required(ErrorMessage = "Debe introducir el conductor.")]
        public string Conductor { get; set; }
    }
}