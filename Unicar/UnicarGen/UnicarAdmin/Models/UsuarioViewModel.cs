using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using UnicarAdmin.DefaultConnection;

namespace UnicarAdmin.Models
{
    public class UsuarioViewModel : RegisterViewModel
    {
        [ScaffoldColumn(false)]
        [Required(ErrorMessage = "Debe introducir nombre usuario.")]
        [Display(Prompt = "Nombre de usuario", Description = "Nombre usuario", Name = "Nombre usuario")]
        public String Nombre_usuario { get; set; }

        [Display(Prompt = "Nombre", Description = "Nombre", Name = "Nombre")]
        [Required(ErrorMessage = "Debe introducir nombre.")]
        public String Nombre { get; set; }

        [Display(Prompt = "Apellidos", Description = "Apellidos", Name = "Apellidos")]
        [Required(ErrorMessage = "Debe introducir apellidos del usuario.")]
        public String Apellidos { get; set; }

        [Display(Prompt = "Valoración Media", Description = "Valoración Media", Name = "Valoración Media")]
        [Range(minimum: 0, maximum: 5, ErrorMessage = "La valoración debe estar entre 0 y 5")]
        [Required(ErrorMessage = "Debe introducir una valoración media.")]
        public double ValoracionMedia { get; set; }

        [Display(Prompt = "Viajes", Description = "Viajes", Name = "Numero de viajes")]
        [Required(ErrorMessage = "Debe introducir el viaje.")]
        public int NumeroViajes { get; set; }


        [Display(Prompt = "Tipo de Usuario", Description = "Tipo de Usuario", Name = "Tipo")]
        [Required(ErrorMessage = "Debe introducir el tipo de Usuario.")]
        public UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum Tipo { get; set; }

    }
}