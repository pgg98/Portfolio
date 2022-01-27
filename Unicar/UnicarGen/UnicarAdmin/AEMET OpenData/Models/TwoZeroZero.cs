﻿// Code generated by Microsoft (R) AutoRest Code Generator 0.16.0.0
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

namespace UnicarAdmin.DefaultConnection
{
    using System;
    using System.Linq;
    using System.Collections.Generic;
    using Newtonsoft.Json;
    using Microsoft.Rest;
    using Microsoft.Rest.Serialization;

    public partial class TwoZeroZero
    {
        /// <summary>
        /// Initializes a new instance of the TwoZeroZero class.
        /// </summary>
        public TwoZeroZero() { }

        /// <summary>
        /// Initializes a new instance of the TwoZeroZero class.
        /// </summary>
        public TwoZeroZero(string descripcion, int estado, string datos, string metadatos)
        {
            Descripcion = descripcion;
            Estado = estado;
            Datos = datos;
            Metadatos = metadatos;
        }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "descripcion")]
        public string Descripcion { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "estado")]
        public int Estado { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "datos")]
        public string Datos { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "metadatos")]
        public string Metadatos { get; set; }

        /// <summary>
        /// Validate the object. Throws ValidationException if validation fails.
        /// </summary>
        public virtual void Validate()
        {
            if (Descripcion == null)
            {
                throw new ValidationException(ValidationRules.CannotBeNull, "Descripcion");
            }
            if (Datos == null)
            {
                throw new ValidationException(ValidationRules.CannotBeNull, "Datos");
            }
            if (Metadatos == null)
            {
                throw new ValidationException(ValidationRules.CannotBeNull, "Metadatos");
            }
        }
    }
}