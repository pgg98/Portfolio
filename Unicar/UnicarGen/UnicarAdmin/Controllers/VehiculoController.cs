using UnicarAdmin.Controllers; //Preguntar por esta libreria
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using UnicarAdmin.Assemblers;
using UnicarAdmin.DefaultConnection;
using UnicarGenNHibernate.CAD.Unicar;
using UnicarGenNHibernate.CEN.Unicar;
using UnicarGenNHibernate.EN.Unicar;

namespace UnicarAdmin.Controllers
{
    [Authorize(Users = "unicar@gmail.com")]
    public class VehiculoController : BasicController
    {
        // GET: Vehiculo
        public ActionResult Index(string searchString)
        {
            SessionInitialize();
            VehiculoCAD veiCAD = new VehiculoCAD(session);
            VehiculoCEN veiCEN = new VehiculoCEN(veiCAD);

            IList<VehiculoEN> listEN = veiCEN.ReadAll(0, -1);
            IEnumerable<VehiculoViewModel> ListViewModel = new VehiculoAssembler().ConvertListENToModel(listEN).ToList();
            if (!String.IsNullOrEmpty(searchString))
            {
                ListViewModel = ListViewModel.Where(s => s.Matricula.ToLower().Contains(searchString.ToLower()));
            }
            SessionClose();

            return View(ListViewModel);
        }

        // GET: Vehiculo/Details/5
        public ActionResult Details(string id)
        {
            SessionInitialize();
            VehiculoCAD veiCAD = new VehiculoCAD(session);
            VehiculoCEN veiCEN = new VehiculoCEN(veiCAD);

            VehiculoViewModel via = new VehiculoAssembler().ConvertENToModelUI(veiCEN.ReadOID(id));
            SessionClose();
            return View(via);
        }

        // GET: Vehiculo/Create
        public ActionResult Create()
        {
            IList<ConductorEN> listaConductores = new ConductorCEN().ReadAll(0, -1);
            IList<SelectListItem> conductoresItems = new List<SelectListItem>();

            foreach (ConductorEN con in listaConductores)
            {
                conductoresItems.Add(new SelectListItem { Text = con.Nombre_usuario, Value = con.Nombre_usuario });
            }

            ViewData["Conductor"] = conductoresItems;
            return View();
        }

        // POST: Vehiculo/Create
        [HttpPost]
        public ActionResult Create(VehiculoViewModel vei)
        {
            try
            {
                // TODO: Add insert logic here
                VehiculoCEN vep = new VehiculoCEN();

                vep.New_(vei.Matricula, vei.Marca, vei.Modelo, vei.Conductor);

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Vehiculo/Edit/5
        public ActionResult Edit(string id)
        {
            
            VehiculoCEN veiCEN = new VehiculoCEN();

            VehiculoViewModel via = new VehiculoAssembler().ConvertENToModelUI(veiCEN.ReadOID(id));

            return View(via);
        }

        // POST: Vehiculo/Edit/5
        [HttpPost]
        public ActionResult Edit(VehiculoViewModel vei)
        {
            try
            {
                // TODO: Add update logic here
                VehiculoCEN vep = new VehiculoCEN();

                vep.Modify(vei.Matricula, vei.Marca, vei.Modelo);

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Vehiculo/Delete/5
        public ActionResult Delete(string id)
        {
            VehiculoViewModel vei = null;
            SessionInitialize();
            VehiculoEN veiEn = new VehiculoCAD(session).ReadOIDDefault(id);
            vei = new VehiculoAssembler().ConvertENToModelUI(veiEn);
            SessionClose();

            return View(vei);
        }

        // POST: Vehiculo/Delete/5
        [HttpPost]
        public ActionResult Delete(string id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here
                SessionInitialize();

                VehiculoCAD vehiculoCAD = new VehiculoCAD(session);
                VehiculoCEN vehiculoCEN = new VehiculoCEN(vehiculoCAD);
                VehiculoEN vehiculoEn = vehiculoCEN.ReadOID(id);
                List<int> idViajes = new List<int>();
                vehiculoEn.Viaje.ToList().ForEach(v => idViajes.Add(v.Id));
                SessionClose();
                VehiculoCEN vehiculoCEN1 = new VehiculoCEN();
                ViajeCEN via = new ViajeCEN();
                //vehiculoCEN1.QuitarViaje(id, idViajes);
                foreach(int Caceres in idViajes)
                {
                    SessionInitialize();
                    ViajeCAD viajeCAD = new ViajeCAD(session);
                    ViajeCEN viajeCEN = new ViajeCEN(viajeCAD);

                    ViajeEN viajeEn = viajeCEN.ReadOID(Caceres);
                    List<string> idPasajeros = new List<string>();
                    viajeEn.Pasajeros.ToList().ForEach(v => idPasajeros.Add(v.Nombre_usuario));
                    SessionClose();
                    ViajeCEN viajeCEN1 = new ViajeCEN();
                    viajeCEN1.QuitarPasajero(Caceres, idPasajeros);
                    viajeEn = viajeCEN1.ReadOID(Caceres);

                    viajeCEN1.Destroy(Caceres);
                }
                vehiculoEn = vehiculoCEN1.ReadOID(id);

                new VehiculoCEN().Destroy(id);
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
