using Newtonsoft.Json;
using RestSharp;
using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Common;
using System.Drawing;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Practica2
{



    public partial class App : Form
    {

        private RestClient client;

        private string[] RESTurls = {"http://www.sigua.ua.es/api/pub/edificio/all/items"
                            , "http://www.sigua.ua.es/api/agregados/seo/edificio/all/items"
                            , "http://www.sigua.ua.es/api/pub/estancia/edificio/{param}/items"
                            , "http://www.sigua.ua.es/api/agregados/seo/departamento/all/items" };

        private string[] options = {"Listado de todos los edificios"
                            , "Listado de datos de volumen de todos los edificios"
                            , "Listado de estancias de un edificio concreto"
                            , "Listado de departamentos" };


        public App()
        {


            
            InitializeComponent();
            pnlApp.Dock = DockStyle.Fill;


            ddlOpciones.DataSource = options;
            ddlOpciones.SelectedValueChanged += lbOpciones_Valuechanged;
            listNombres.SelectedValueChanged += listNombres_Valuechanged;

            tbParam.KeyPress += tbParam_Pulsa;

            tbParam.Enabled = false;
            tbParam.MaxLength = 4;


        }

        private void tbParam_Pulsa(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar) &&
                (e.KeyChar != '.'))
            {
                e.Handled = true;
            }

        }

        List<Edificio> getAllEdificios()
        {
            string parsedurl;
            parsedurl = this.RESTurls[0];
            client = new RestClient(parsedurl);
            return client.Execute<List<Edificio>>(new RestRequest()).Data;
        }


        List<Volumen> getAllVolumenEdificios()
        {
            string parsedurl;
            parsedurl = this.RESTurls[1];
            client = new RestClient(parsedurl);
            return client.Execute<List<Volumen>>(new RestRequest()).Data;
        }

        List<EstanciaDTO> getEstanciasPorId(string id)
        {
            string parsedurl;
            string url = this.RESTurls[2];
            parsedurl = url.Replace("{param}", id);
            client = new RestClient(parsedurl);

            return client.Execute<List<EstanciaDTO>>(new RestRequest()).Data;


        }


        List<Volumen> getAllVolumenDept()
        {
            string parsedurl;
            parsedurl = this.RESTurls[3];
            client = new RestClient(parsedurl);
            return client.Execute<List<Volumen>>(new RestRequest()).Data;
        }




        private void btnBuscar_Click(object sender, EventArgs e)
        {

            string parsedurl;
            if ((ddlOpciones.SelectedIndex == 2 || ddlOpciones.SelectedIndex == 3) && tbParam.Text.Length == 0)
            {

                //mostrar mensaje de error

            }
            else {
                switch (ddlOpciones.SelectedIndex)
                {
                    case 0:
                        gdvSigua.DataSource = getAllEdificios();
                        break;

                    case 1:

                        gdvSigua.DataSource = getAllVolumenEdificios();

                        break;
                    case 2:

                        List<EstanciaDTO> data = getEstanciasPorId(rellenaZeros(tbParam.Text));
                        
                        if(data != null)
                        {
                            IList<Feature> features = data[0].features;
                            Custproperties props;
                            ArrayList estancias = new ArrayList();
                            Estancia curent;

                            for (int i = 0; i < features.Count; ++i)
                            {
                                curent = new Estancia();
                                props = features[i].properties;
                                curent.Actividad = props.nombre_actividad;
                                curent.Id = props.codigo;
                                curent.Denominacion = JsonConvert.SerializeObject(props.denominacion);
                                curent.Superficie = props.superficie;
                                estancias.Add(curent);
                            }
                            gdvSigua.DataSource = estancias;
                        }

                        break;

                    case 3:

                        int nmin = Int32.Parse(tbParam.Text);
                        List<Volumen> filteredDep = getAllVolumenDept().Where(x => Int32.Parse(x.Ocupantes) > nmin).ToList();
                        gdvSigua.DataSource = filteredDep;
                        break;

                    default:
                        break;
                }
            }
        }

        private string rellenaZeros(string text)
        {
            string copy = text;
            while (copy.Length < 4)
            {
                copy = copy.Insert(0, "0");
            }
            return copy;
        }

        private void lbOpciones_Valuechanged(object sender, EventArgs e)
        {

            string parsedurl;

            if (ddlOpciones.SelectedIndex == 2 || ddlOpciones.SelectedIndex == 3) tbParam.Enabled = true;
            else tbParam.Enabled = false;

            if (ddlOpciones.SelectedIndex == 3) { lblP1.Text = "Min. Ocupantes"; tbParam.Text = "0"; }
            else if (ddlOpciones.SelectedIndex == 0 || ddlOpciones.SelectedIndex == 1) { lblP1.Text = "Parámetro"; }
            else lblP1.Text = "Id. de Edificio";

            if (ddlOpciones.SelectedIndex == 2) {
                parsedurl = this.RESTurls[0];
                client = new RestClient(parsedurl);
                var response_0 = client.Execute<List<EdificioMin>>(new RestRequest());
                listNombres.DataSource = response_0.Data;
            }


        }

        private void listNombres_Valuechanged(object sender, EventArgs e)
        {

            //ID: 0008 Nombre: FACULTAD DE CIENCIAS I
            string aux = listNombres.SelectedItem.ToString();

            string[] words = aux.Split(' ');

            if(words[1] != null) tbParam.Text = words[1];

        }
        private void lblParam_Click(object sender, EventArgs e)
        {

        }

        private void lblOpciones_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click_1(object sender, EventArgs e)
        {

        }

        private void tbParam_TextChanged(object sender, EventArgs e)
        {

        }
        private void gdvSigua_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

    }

    public class Edificio
    {
        [JsonProperty(PropertyName = "id")]
        public string Id { get; set; }

        [JsonProperty(PropertyName = "nombre")]
        public string Nombre { get; set; }

        [JsonProperty(PropertyName = "[plantas")]
        public string Plantas { get; set; }
    }

    public class EdificioMin
    {

        [JsonProperty(PropertyName = "id")]
        public string Id { get; set; }

        [JsonProperty(PropertyName = "nombre")]
        public string Nombre { get; set; }

        public override string ToString()
        {
            return "ID: " + Id + " Nombre: " + Nombre;
        }

    }

    public class Volumen
    {
        [JsonProperty(PropertyName = "id")]
        public string Id { get; set; }

        [JsonProperty(PropertyName = "superficie")]
        public string Superficie { get; set; }

        [JsonProperty(PropertyName = "[estancias")]
        public string Estancias { get; set; }

        [JsonProperty(PropertyName = "[ocupantes")]
        public string Ocupantes { get; set; }
    }


    public class Estancia
    {
        [JsonProperty(PropertyName = "codigo")]
        public string Id { get; set; }

        [JsonProperty(PropertyName = "denominacion")]
        public string Denominacion { get; set; }

        [JsonProperty(PropertyName = "superficie")]
        public decimal Superficie { get; set; }

        [JsonProperty(PropertyName = "nombre_actividad")]
        public string Actividad { get; set; }
    }
}
