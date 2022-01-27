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
    public class AdministradorController : BasicController
    {        
        // GET: Administrador
        public ActionResult Index(string searchString)
        {
            SessionInitialize();
            AdministradorCAD pasaCAD = new AdministradorCAD(session);
            AdministradorCEN pasaCEN = new AdministradorCEN(pasaCAD);

            IList<AdministradorEN> listEN = pasaCEN.ReadAll(0, -1);
            IEnumerable<AdministradorViewModel> ListViewModel = new AdministradorAssembler().ConvertListENToModel(listEN).ToList();
            if (!String.IsNullOrEmpty(searchString))
            {
                ListViewModel = ListViewModel.Where(s => s.Nombre_usuario.ToLower().Contains(searchString.ToLower()));
            }
            SessionClose();

            return View(ListViewModel);
        }

        // GET: Administrador/Details/5
        public ActionResult Details(string id)
        {
            SessionInitialize();
            AdministradorCAD pasaCAD = new AdministradorCAD(session);
            AdministradorCEN pasaCEN = new AdministradorCEN(pasaCAD);

            AdministradorViewModel pasV = new AdministradorAssembler().ConvertENToModelUI(pasaCEN.ReadOID(id));
            SessionClose();
            return View(pasV);
        }

        // GET: Administrador/Create
        public ActionResult Create()
        {
            AdministradorViewModel pasa = new AdministradorViewModel();
            pasa.Tipo = UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum.Administrador;
            return View(pasa);
        }

        // POST: Administrador/Create
        [HttpPost]
        public ActionResult Create(AdministradorViewModel pasa)
        {
            try
            {
                // TODO: Add insert logic here
                AdministradorCEN pas = new AdministradorCEN();

                pas.New_(pasa.Nombre_usuario, pasa.Nombre, pasa.Apellidos, pasa.Email, pasa.Password, 0.0, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum.Administrador);

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Administrador/Edit/5
        public ActionResult Edit(string id)
        {

            AdministradorCEN pasaCEN = new AdministradorCEN();

            AdministradorViewModel via = new AdministradorAssembler().ConvertENToModelUI(pasaCEN.ReadOID(id));
            via.Tipo = UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum.Administrador;

            return View(via);
        }

        // POST: Administrador/Edit/5
        [HttpPost]
        public ActionResult Edit(AdministradorViewModel pasa)
        {
            try
            {
                // TODO: Add update logic here
                AdministradorCEN pas = new AdministradorCEN();

                pas.Modify(pasa.Nombre_usuario, pasa.Nombre, pasa.Apellidos, pasa.Email, pasa.Password, 0.0, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum.Administrador);

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Administrador/Delete/5
        public ActionResult Delete(string id)
        {
            AdministradorViewModel pasa = null;
            SessionInitialize();
            AdministradorEN pasaEn = new AdministradorCAD(session).ReadOIDDefault(id);
            pasa = new AdministradorAssembler().ConvertENToModelUI(pasaEn);
            SessionClose();


            return View(pasa);
        }

        // POST: Administrador/Delete/5
        [HttpPost]
        public ActionResult Delete(string id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here 
                AdministradorCEN ad = new AdministradorCEN();

                ad.Destroy(id);

                return RedirectToAction("Index");
            }
            catch (Exception e)
            {
                return View(e.Message);
            }
        }
        
    }
}