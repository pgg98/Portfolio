using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using UnicarAdmin.Assemblers;
using UnicarAdmin.DefaultConnection;
using UnicarAdmin.Models;
using UnicarGenNHibernate.CAD.Unicar;
using UnicarGenNHibernate.CEN.Unicar;
using UnicarGenNHibernate.EN.Unicar;

namespace UnicarAdmin.Controllers
{
    [Authorize(Users = "unicar@gmail.com")]
    public class ConductorController : BasicController 
    {
        // GET: Conductor
        public ActionResult Index(string searchString)
        {
            SessionInitialize();
            ConductorCAD condCAD = new ConductorCAD(session);
            ConductorCEN condCEN = new ConductorCEN(condCAD);

            IList<ConductorEN> listEN = condCEN.ReadAll(0, -1);
            IEnumerable<ConductorViewModel> ListViewModel = new ConductorAssembler().ConvertListENToModel(listEN).ToList();
            if (!String.IsNullOrEmpty(searchString))
            {
                ListViewModel = ListViewModel.Where(s => s.Nombre_usuario.ToLower().Contains(searchString.ToLower()));
            }
            SessionClose();

            return View(ListViewModel);
        }

        // GET: Conductor/Details/5
        public ActionResult Details(string id)
        {
            SessionInitialize();
            ConductorCAD condCAD = new ConductorCAD(session);
            ConductorCEN condCEN = new ConductorCEN(condCAD);

            ConductorViewModel via = new ConductorAssembler().ConvertENToModelUI(condCEN.ReadOID(id));
            SessionClose();
            return View(via);
        }

        // GET: Conductor/Create
        public ActionResult Create()
        {
            ConductorViewModel con = new ConductorViewModel();
            con.Tipo = UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum.Conductor;
            return View(con);
        }

        // POST: Conductor/Create
        [HttpPost]
        public ActionResult Create(ConductorViewModel cond)
        {
            try
            {
                // TODO: Add insert logic here
                ConductorCEN con = new ConductorCEN();
                con.New_(cond.Nombre_usuario, cond.Nombre, cond.Apellidos, cond.Email, cond.Password, cond.ValoracionMedia, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum.Conductor,cond.Restriccion);

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Conductor/Edit/5
        public ActionResult Edit(string id)
        {

            ConductorCEN condCEN = new ConductorCEN();

            ConductorViewModel via = new ConductorAssembler().ConvertENToModelUI(condCEN.ReadOID(id));
            via.Tipo = UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum.Conductor;


            return View(via);
        }

        // POST: Conductor/Edit/5
        [HttpPost]
        public ActionResult Edit(ConductorViewModel cond)
        {
            try
            {
                // TODO: Add update logic here
                ConductorCEN con = new ConductorCEN();
                con.Modify(cond.Nombre_usuario, cond.Nombre, cond.Apellidos, cond.Email, cond.Password, cond.ValoracionMedia, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum.Conductor, cond.Restriccion);

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Conductor/Delete/5
        public ActionResult Delete(string id)
        {
            ConductorViewModel cond = null;
            SessionInitialize();
            ConductorEN condEn = new ConductorCAD(session).ReadOIDDefault(id);
            cond = new ConductorAssembler().ConvertENToModelUI(condEn);
            SessionClose();

            return View(cond);
        }

        // POST: Conductor/Delete/5
        [HttpPost]
        public ActionResult Delete(string id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here
                SessionInitialize();

                ConductorCAD ConductorCAD = new ConductorCAD(session);
                ConductorCEN ConductorCEN = new ConductorCEN(ConductorCAD);
                ConductorEN ConductorEn = ConductorCEN.ReadOID(id);
                List<int> idViajes = new List<int>();
                List<string> idVehiculo = new List<string>();
                ConductorEn.Viaje.ToList().ForEach(v => idViajes.Add(v.Id));
                ConductorEn.Vehiculo.ToList().ForEach(v1 => idVehiculo.Add(v1.Matricula));

                SessionClose();

                ViajeController vias = new ViajeController();
                foreach (int Caceres in idViajes)
                {
                    vias.Delete(Caceres, new FormCollection());
                }

                
                foreach (string Caceres1 in idVehiculo)
                {
                    new VehiculoCEN().Destroy(Caceres1);
                }

                new ConductorCEN().Destroy(id);

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}