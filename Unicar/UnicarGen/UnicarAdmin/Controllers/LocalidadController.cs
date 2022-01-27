using UnicarAdmin.Controllers; 
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
using System.Threading.Tasks;

namespace UnicarAdmin.Controllers
{
    [Authorize(Users = "unicar@gmail.com")]
    public class LocalidadController : BasicController
    {
        // GET: Localidad
        public ActionResult Index(string searchString)
        {
            SessionInitialize();
            LocalidadCAD locCAD = new LocalidadCAD(session);
            LocalidadCEN locCEN = new LocalidadCEN(locCAD);

            IList<LocalidadEN> locEN = locCEN.ReadAll(0, -1).ToList();
            IEnumerable<LocalidadViewModel> ListViewModel = new LocalidadAssembler().ConvertListENToModel(locEN).ToList();
            if (!String.IsNullOrEmpty(searchString)) {
                ListViewModel = ListViewModel.Where(s => s.nombre.ToLower().Contains(searchString.ToLower()));
            }
            
            SessionClose();

            return View(ListViewModel);
        }

        // GET: Localidad/Details/5
        public ActionResult Details(int id)
        {

            SessionInitialize();

            LocalidadCAD locaCAD = new LocalidadCAD(session);
            LocalidadCEN locaCEN = new LocalidadCEN(locaCAD);

            LocalidadViewModel loc = new LocalidadAssembler().ConvertENToModelUI(locaCEN.ReadOID(id));

            SessionClose();

            return View(loc);
        }

        // GET: Localidad/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Localidad/Create
        [HttpPost]
        public ActionResult Create(FormCollection collection)
        {
            try
            {
                // TODO: Add insert logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Localidad/Edit/5
        public ActionResult Edit(int id)
        {
            LocalidadViewModel loca = null;
            SessionInitialize();
            LocalidadEN locaEn = new LocalidadCAD(session).ReadOIDDefault(id);
            loca = new LocalidadAssembler().ConvertENToModelUI(locaEn);

            SessionClose();

            return View(loca);
           
        }

        // POST: Localidad/Edit/5
        [HttpPost]
        public ActionResult Edit(LocalidadViewModel loca)
        {
            try
            {
                // TODO: Add update logic here
                LocalidadCEN cen = new LocalidadCEN();
                cen.Modify(loca.id, loca.nombre, loca.latitud, loca.longitud);

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Localidad/Delete/5
        public ActionResult Delete(int id)
        {
            LocalidadViewModel loca = null;
            SessionInitialize();
            LocalidadEN locaEn = new LocalidadCAD(session).ReadOIDDefault(id);
            loca = new LocalidadAssembler().ConvertENToModelUI(locaEn);
            SessionClose();
            
            return View(loca);
        }

        // POST: Localidad/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here
                new LocalidadCEN().Destroy(id);
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
