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
using UnicarAdmin.Models;
using UnicarGenNHibernate.CP.Unicar;

namespace UnicarAdmin.Controllers
{
    [Authorize(Users = "unicar@gmail.com")]
    public class PasajeroController : BasicController
    {
        // GET: Pasajero
        public ActionResult Index(string searchString)
        {
            SessionInitialize();
            PasajeroCAD pasaCAD = new PasajeroCAD(session);
            PasajeroCEN pasaCEN = new PasajeroCEN(pasaCAD);

            IList<PasajeroEN> listEN = pasaCEN.ReadAll(0, -1);
            IEnumerable<PasajeroViewModel> ListViewModel = new PasajeroAssembler().ConvertListENToModel(listEN).ToList();
            if (!String.IsNullOrEmpty(searchString))
            {
                ListViewModel = ListViewModel.Where(s => s.Nombre_usuario.ToLower().Contains(searchString.ToLower()));
            }
            SessionClose();

            return View(ListViewModel);
        }

        // GET: Pasajero/Details/5
        public ActionResult Details(string id)
        {
            SessionInitialize();
            PasajeroCAD pasaCAD = new PasajeroCAD(session);
            PasajeroCEN pasaCEN = new PasajeroCEN(pasaCAD);

            PasajeroViewModel pasV = new PasajeroAssembler().ConvertENToModelUI(pasaCEN.ReadOID(id));
            SessionClose();
            return View(pasV);
        }

        // GET: Pasajero/Create
        public ActionResult Create()
        {
            PasajeroViewModel pasa = new PasajeroViewModel();
            pasa.Tipo = UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum.Pasajero;
            return View(pasa);
        }

        // POST: Pasajero/Create
        [HttpPost]
        public ActionResult Create(PasajeroViewModel pasa)
        {
            try
            {
                // TODO: Add insert logic here
                PasajeroCEN pas = new PasajeroCEN();

                pas.New_(pasa.Nombre_usuario, pasa.Nombre, pasa.Apellidos, pasa.Email, pasa.Password, pasa.ValoracionMedia, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum.Pasajero);

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Pasajero/Edit/5
        public ActionResult Edit(string id)
        {
            
            PasajeroCEN pasaCEN = new PasajeroCEN();

            PasajeroViewModel via = new PasajeroAssembler().ConvertENToModelUI(pasaCEN.ReadOID(id));
            via.Tipo = UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum.Pasajero;

            return View(via);
        }

        // POST: Pasajero/Edit/5
        [HttpPost]
        public ActionResult Edit(PasajeroViewModel pasa)
        {
            try
            {
                // TODO: Add update logic here
                PasajeroCEN pas = new PasajeroCEN();

                pas.Modify(pasa.Nombre_usuario, pasa.Nombre, pasa.Apellidos, pasa.Email, pasa.Password, pasa.ValoracionMedia, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum.Pasajero);

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Pasajero/Delete/5
        public ActionResult Delete(string id)
        {
            PasajeroViewModel pasa = null;
            SessionInitialize();
            PasajeroEN pasaEn = new PasajeroCAD(session).ReadOIDDefault(id);
            pasa = new PasajeroAssembler().ConvertENToModelUI(pasaEn);
            SessionClose();
            

            return View(pasa);
        }

        // POST: Pasajero/Delete/5
        [HttpPost]
        public ActionResult Delete(string id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here 
                PasajeroCP piti = new PasajeroCP();

                piti.BorrarPasajero(id);

                return RedirectToAction("Index");
            }
            catch(Exception e)
            {
                return View(e.Message);
            }
        }
    }
}
