using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using UnicarGenNHibernate.CAD.Unicar;
using UnicarGenNHibernate.CEN.Unicar;
using UnicarGenNHibernate.EN.Unicar;
using UnicarAdmin.Assemblers;
using UnicarAdmin.DefaultConnection;

namespace UnicarAdmin.Controllers
{
    [Authorize(Users = "unicar@gmail.com")]
    public class ViajeController : BasicController
    {
        // GET: Viaje
        public ActionResult Index(string searchString)
        {
            SessionInitialize();

            ViajeCAD viaCAD = new ViajeCAD(session);
            ViajeCEN viaCEN = new ViajeCEN(viaCAD);

            IList<ViajeEN> listEN = viaCEN.ReadAll(0, -1);
            IEnumerable<ViajeViewModel> ListViewModel = new ViajeAssembler().ConvertListENToModel(listEN).ToList();
            if (!String.IsNullOrEmpty(searchString))
            {

                ListViewModel = ListViewModel.Where(s => s.Id.ToString().Contains(searchString));
            }

            SessionClose();

            return View(ListViewModel);
        }

        // GET: Viaje/Details/5
        public ActionResult Details(int id)
        {
            SessionInitialize();

            ViajeCAD viaCAD = new ViajeCAD(session);
            ViajeCEN viaCEN = new ViajeCEN(viaCAD);

            ViajeViewModel via = new ViajeAssembler().ConvertENToModelUI(viaCEN.ReadOID(id));

            SessionClose();

            return View(via);
      
        }

        // GET: Viaje/Create
        public ActionResult Create()
        {
            IList<LocalidadEN> listaLocalidades = new LocalidadCEN().ReadAll(0, -1);
            IList<SelectListItem> localidadesItems = new List<SelectListItem>();

            foreach (LocalidadEN loc in listaLocalidades)
            {
                localidadesItems.Add(new SelectListItem { Text = loc.Nombre, Value = loc.Id.ToString() });
            }

            ViewData["LocalidadLlegada"] = localidadesItems;

            IList<LocalidadEN> listaLocalidades1 = new LocalidadCEN().ReadAll(0, -1);
            IList<SelectListItem> localidadesItems1 = new List<SelectListItem>();

            foreach (LocalidadEN loc1 in listaLocalidades1)
            {
                localidadesItems1.Add(new SelectListItem { Text = loc1.Nombre, Value = loc1.Id.ToString() });
            }

            ViewData["LocalidadSalida"] = localidadesItems1;

            IList<ConductorEN> listaConductores = new ConductorCEN().ReadAll(0, -1);
            IList<SelectListItem> ConductoresItems = new List<SelectListItem>();

            foreach (ConductorEN cond in listaConductores)
            {
                ConductoresItems.Add(new SelectListItem { Text = cond.Nombre_usuario, Value = cond.Nombre_usuario.ToString() });
            }

            ViewData["Conductor"] = ConductoresItems;


            return View();
        }

        // POST: Viaje/Create
        [HttpPost]
        public ActionResult Create(ViajeViewModel viajeViewModel)
        {
            try
            {
                // TODO: Add insert logic here
                ViajeCEN viajeCEN = new ViajeCEN();
                DireccionCEN direccionCEN = new DireccionCEN();
                DireccionCEN direccionCEN1 = new DireccionCEN();
                LocalidadCEN localidadCEN = new LocalidadCEN();
                int direSalida = direccionCEN.New_(viajeViewModel.LocalidadSalida, viajeViewModel.DireccionSalida);
                int direLlega = direccionCEN.New_(viajeViewModel.LocalidadLlegada, viajeViewModel.DireccionLlegada);

                String precio1 = viajeViewModel.Precio.ToString();
                precio1.Replace('.',',');
                double preciofinal = Double.Parse(precio1);

                if (viajeViewModel.Plazas >= viajeViewModel.PlazasOcupadas) { 
                    int v = viajeCEN.New_(viajeViewModel.FechaSalida,viajeViewModel.FechaLlegada,viajeViewModel.Conductor,viajeViewModel.Plazas,preciofinal,viajeViewModel.Vehiculo, direSalida, direLlega, viajeViewModel.PlazasOcupadas, viajeViewModel.HoraSalida, viajeViewModel.HoraLlegada);
                }
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Viaje/Edit/5
        public ActionResult Edit(int id)
        {
            ViajeViewModel via = null;
            SessionInitialize();
            ViajeEN viaen = new ViajeCAD(session).ReadOIDDefault(id);
            via = new ViajeAssembler().ConvertENToModelUI(viaen);
            SessionClose();
            return View(via);
        }

        // POST: Viaje/Edit/5
        [HttpPost]
        public ActionResult Edit(ViajeViewModel via)
        {
            try
            {
                // TODO: Add update logic here
                ViajeCEN viaCEN = new ViajeCEN();
                viaCEN.Modify(via.Id, via.FechaSalida, via.FechaLlegada, via.Plazas, via.Precio, via.PlazasOcupadas,via.HoraSalida, via.HoraLlegada);

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Viaje/Delete/5
        public ActionResult Delete(int id) {

            ViajeViewModel viaje = null;
            SessionInitialize();
            ViajeEN viajeEn = new ViajeCAD(session).ReadOIDDefault(id);         
            viaje = new ViajeAssembler().ConvertENToModelUI(viajeEn);
            SessionClose();
           
            return View(viaje);
        }

        // POST: Viaje/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        { 
            try
            {
                // TODO: Add delete logic here

                //BORRADO DE PASAJEROS    
                SessionInitialize();
                ViajeCAD viajeCAD = new ViajeCAD(session);
                ViajeCEN viajeCEN = new ViajeCEN(viajeCAD);
                ViajeEN viajeEn = viajeCEN.ReadOID(id);
                List<string> idPasajeros = new List<string>();
                viajeEn.Pasajeros.ToList().ForEach(v => idPasajeros.Add(v.Nombre_usuario));
                SessionClose();
                ViajeCEN viajeCEN1 = new ViajeCEN();
                viajeCEN1.QuitarPasajero(id, idPasajeros);
                viajeEn = viajeCEN1.ReadOID(id);


                //BORRADO DE ALERTA
                SessionInitialize();
                ViajeCAD viajeCAD1 = new ViajeCAD(session);
                ViajeCEN viajeCEN2 = new ViajeCEN(viajeCAD1);
                ViajeEN viajeEN = viajeCEN2.ReadOID(id);
                List<int> idAlerta = new List<int>();
                viajeEN.Alerta.ToList().ForEach(v => idAlerta.Add(v.Id));
                SessionClose();
                ViajeCEN viajeCEN3 = new ViajeCEN();
                AlertaCEN alertaCEN = new AlertaCEN();
                foreach (int Caceres in idAlerta)
                {
                    AlertaCEN alet = new AlertaCEN();
                    alet.Destroy(Caceres);
                }

                //BORRADO DE VIAJE
                viajeCEN1.Destroy(id);

                return RedirectToAction("Index");
            }
            catch (Exception e)
            {
                return View();
            }

        }
    }
}
