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
    public class DireccionController : BasicController
    {
        // GET: Direccion
        public ActionResult Index(string searchString)
        {

                SessionInitialize();
            DireccionCAD dirCAD = new DireccionCAD(session);
            DireccionCEN dirCEN = new DireccionCEN(dirCAD);

            IList<DireccionEN> listEN = dirCEN.ReadAll(0, -1);
            IEnumerable<DireccionViewModel> ListViewModel = new DireccionAssembler().ConvertListENToModel(listEN).ToList();
            if (!String.IsNullOrEmpty(searchString))
            {
                ListViewModel = ListViewModel.Where(s => s.Direccion.ToLower().Contains(searchString.ToLower()));
            }
            SessionClose();

            return View(ListViewModel);

        }

        // GET: Direccion/Details/5
        public ActionResult Details(int id)
        {
            SessionInitialize();

            DireccionCAD dirCAD = new DireccionCAD(session);
            DireccionCEN dirCEN = new DireccionCEN(dirCAD);

            DireccionViewModel dir = new DireccionAssembler().ConvertENToModelUI(dirCEN.ReadOID(id));

            SessionClose();

            return View(dir);
        }

        // GET: Direccion/Create
        public ActionResult Create()
        {
            IList<LocalidadEN> listaLocalidades = new LocalidadCEN().ReadAll(0, -1);
            IList<SelectListItem> localidadesItems = new List<SelectListItem>();

            foreach (LocalidadEN loc in listaLocalidades)
            {
                localidadesItems.Add(new SelectListItem { Text = loc.Nombre, Value = loc.Id.ToString() });
            }

            ViewData["Localidad"] = localidadesItems;

            return View();
        }

        // POST: Direccion/Create
        [HttpPost]
        public ActionResult Create(DireccionViewModel dire)
        {

            try
            {
                DireccionCEN dirCEN = new DireccionCEN();
                dirCEN.New_(dire.Localidad, dire.Direccion);
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
            DireccionViewModel dir = null;
            SessionInitialize();
            DireccionEN diren = new DireccionCAD(session).ReadOIDDefault(id);
            dir = new DireccionAssembler().ConvertENToModelUI(diren);
            SessionClose();
            return View(dir);
        }

        // POST: Direccion/Edit/5
        [HttpPost]
        public ActionResult Edit(DireccionViewModel dir)
        {
            try
            {
                // TODO: Add update logic here
                DireccionCEN dirCEN = new DireccionCEN();
                dirCEN.Modify(dir.id, dir.Direccion);

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
            DireccionViewModel dir = null;
            SessionInitialize();
            DireccionEN diren = new DireccionCAD(session).ReadOIDDefault(id);
            dir = new DireccionAssembler().ConvertENToModelUI(diren);
            SessionClose();
            return View(dir);
        }

        // POST: Direccion/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here
                DireccionCEN dirCEN = new DireccionCEN();
                dirCEN.Destroy(id);
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}