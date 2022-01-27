using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using UnicarAdmin.Assemblers;
using UnicarAdmin.Models;
using UnicarGenNHibernate.CAD.Unicar;
using UnicarGenNHibernate.CEN.Unicar;
using UnicarGenNHibernate.EN.Unicar;

namespace UnicarAdmin.Controllers
{
    [Authorize(Users = "unicar@gmail.com")]
    public class ValoracionController : BasicController
    {
        // GET: Direccion
        public ActionResult Index(string searchString)
        {

            SessionInitialize();
            ValoracionCAD varCAD = new ValoracionCAD(session);
            ValoracionCEN varCEN = new ValoracionCEN(varCAD);

            IList<ValoracionEN> listEN = varCEN.ReadAll(0, -1);
            IEnumerable<ValoracionViewModel> ListViewModel = new ValoracionAssembler().ConvertListENToModel(listEN).ToList();
            if (!String.IsNullOrEmpty(searchString))
            {
                ListViewModel = ListViewModel.Where(s => s.Viaje.ToString().Contains(searchString));
            }
            SessionClose();

            return View(ListViewModel);

        }

        // GET: Direccion/Details/5
        public ActionResult Details(int id)
        {
            SessionInitialize();

            ValoracionCAD varCAD = new ValoracionCAD(session);
            ValoracionCEN varCEN = new ValoracionCEN(varCAD);

            ValoracionViewModel var = new ValoracionAssembler().ConvertENToModelUI(varCEN.ReadOID(id));

            SessionClose();

            return View(var);
        }

        // GET: Direccion/Create
        public ActionResult Create()
        {
            IList<ViajeEN> listaViajees1 = new ViajeCEN().ReadAll(0, -1);
            IList<SelectListItem> ViajeesItems1 = new List<SelectListItem>();

            foreach (ViajeEN via in listaViajees1)
            {
                ViajeesItems1.Add(new SelectListItem { Text = via.Id.ToString(), Value = via.Id.ToString() });
            }

            ViewData["Viaje"] = ViajeesItems1;

            IList<PasajeroEN> listaPasajeroes = new PasajeroCEN().ReadAll(0, -1);
            IList<SelectListItem> PasajeroesItems = new List<SelectListItem>();

            foreach (PasajeroEN usu in listaPasajeroes)
            {
                PasajeroesItems.Add(new SelectListItem { Text = usu.Nombre_usuario, Value = usu.Nombre_usuario.ToString() });
            }

            ViewData["Pasajero"] = PasajeroesItems;
            return View();
        }

        // POST: Direccion/Create
        [HttpPost]
        public ActionResult Create(ValoracionViewModel var)
        {

            try
            {
                ValoracionCEN varCEN = new ValoracionCEN();
                varCEN.Crearvaloracion (var.Comentario,var.Valoracion, var.Viaje, var.Pasajero) ;
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Direccion/Edit/5
        public ActionResult Edit(int id)
        {
            ValoracionViewModel valor = null;
            SessionInitialize();
            ValoracionEN valEn = new ValoracionCAD(session).ReadOIDDefault(id);
            valor = new ValoracionAssembler().ConvertENToModelUI(valEn);

            SessionClose();

            return View(valor);
        }

        // POST: Direccion/Edit/5
        [HttpPost]
        public ActionResult Edit(ValoracionViewModel valvi)
        {
            try
            {
                // TODO: Add update logic here
                ValoracionCEN valora = new ValoracionCEN();
                valora.Modificarvaloracion(valvi.id, valvi.Comentario, valvi.Valoracion);

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Direccion/Delete/5
        public ActionResult Delete(int id)
        {
            ValoracionViewModel valora = null;
            SessionInitialize();
            ValoracionEN valEn = new ValoracionCAD(session).ReadOIDDefault(id);
            valora = new ValoracionAssembler().ConvertENToModelUI(valEn);
            SessionClose();

            return View(valora);
        }

        // POST: Direccion/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here
                new ValoracionCEN().Eliminarvaloracion(id);
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}