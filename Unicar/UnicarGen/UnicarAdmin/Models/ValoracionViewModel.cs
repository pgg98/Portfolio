using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;


namespace UnicarAdmin.Models
{
    public class ValoracionViewModel
    {
        [ScaffoldColumn(false)]
        public int id { get; set; }

        [Display(Prompt = "Comentario de usuario", Description = "Comentario de usuario", Name = "Comentario")]
        [Required(ErrorMessage = "Debe introducir un comentario válido.")]
        public String Comentario { get; set; }

        [Display(Prompt = "Valoracion usuario", Description = "Valoracion usuario", Name = "Valoracion")]
        [Range(minimum: 0, maximum: 5, ErrorMessage = "La valoración debe estar entre 0 y 5")]
        [Required(ErrorMessage = "Debe introducir una valoración válida.")]
        public int Valoracion { get; set; }

        [Display(Prompt = "Viaje valorado", Description = "Viaje valorado", Name = "Viaje")]
        [Required(ErrorMessage = "Debe introducir un viaje.")]
        public int Viaje { get; set; }

        [Display(Prompt = "Pasajero que valora", Description = "Pasajero que valora", Name = "Pasjero")]
        [Required(ErrorMessage = "Debe introducir un pasajero.")]
        public string Pasajero { get; set; }

    }
}