using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace UnicarAdmin.Models
{
    public class AdministradorViewModel
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

        [Display(Prompt = "Email", Description = "Email", Name = "Email")]
        [DataType(DataType.EmailAddress)]
        [Required(ErrorMessage = "Debe introducir un email.")]
        public String Email { get; set; }

        [Display(Prompt = "Contraseña", Description = "Contraseña", Name = "Contraseña")]
        [DataType(DataType.Password)]
        [Required(ErrorMessage = "Debe introducir una contraseña.")]
        public String Password { get; set; }

        [Display(Prompt = "Tipo de Usuario", Description = "Tipo de Usuario", Name = "Tipo")]
        [Required(ErrorMessage = "Debe introducir el tipo de Usuario.")]
        public UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum Tipo { get; set; }
    }
}