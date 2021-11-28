using Newtonsoft.Json;
using System.Collections.Generic;

namespace Practica2
{
    public class Custproperties
    {
        public string codigo { get; set; }
        public int id_actividad { get; set; }
        public string nombre_actividad { get; set; }
        public decimal superficie { get; set; }
  
        public string nombre_departamentosigua { get; set; }
        public object denominacion { get; set; }
        public string ubicaciones { get; set; }
        public object observaciones { get; set; }
        public string crue { get; set; }
        public string u21 { get; set; }
        public string activresum { get; set; }
    }

    public class Geometry
    {
        [JsonProperty(PropertyName = "type")]
        public string type { get; set; }
        [JsonProperty(PropertyName = "coordinates")]
        public IList<IList<IList<IList<double>>>> coordinates { get; set; }
    }

    public class Feature
    {
        [JsonProperty(PropertyName = "type")]
        public string type { get; set; }

        [JsonProperty(PropertyName = "geometry")]
        public Geometry geometry { get; set; }

        [JsonProperty(PropertyName = "properties")]
        public Custproperties properties { get; set; }
    }

    public class EstanciaDTO
    {
        [JsonProperty(PropertyName = "type")]
        public string type { get; set; }
        [JsonProperty(PropertyName = "features")]
        public IList<Feature> features { get; set; }
    }

}
