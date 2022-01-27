using UnicarAdmin.Controllers;
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
using UnicarGenNHibernate.CP.Unicar;

namespace UnicarAdmin.Controllers
{
    [Authorize(Users = "unicar@gmail.com")]
    public class AlertaController : BasicController
    {
        // GET: Alerta
        public ActionResult Index(string searchString)
        {
            IEnumerable<AlertaViewModel> ListViewModel = null;
            SessionInitialize();
            AlertaCAD aleCAD = new AlertaCAD(session);
            AlertaCEN aleCEN = new AlertaCEN(aleCAD);

            IList<AlertaEN> aleEN = aleCEN.ReadAll(0, -1);
            ListViewModel = new AlertaAssembler().ConvertListENToModel(aleEN).ToList();
            if (!String.IsNullOrEmpty(searchString))
            {
                ListViewModel = ListViewModel.Where(s => s.Id.ToString().Contains(searchString));
            }
            SessionClose();

            return View(ListViewModel);
        }

        // GET: Alerta/Details/5
        public ActionResult Details(int id)
        {
            SessionInitialize();
            AlertaCAD aleCAD = new AlertaCAD(session);
            AlertaCEN aleCEN = new AlertaCEN(aleCAD);

            AlertaViewModel ale = new AlertaAssembler().ConvertENToModelUI(aleCEN.ReadOID(id));
            SessionClose();
            return View(ale);
        }

        // GET: Alerta/Create
        public ActionResult Create()
        {
            IList<UsuarioEN> listaUsuario = new UsuarioCEN().ReadAll(0, -1);
            IList<SelectListItem> usuarioItems = new List<SelectListItem>();

            foreach (UsuarioEN usu in listaUsuario)
            {
                usuarioItems.Add(new SelectListItem { Text = usu.Nombre_usuario, Value = usu.Nombre_usuario });
            }

            ViewData["Usuario"] = usuarioItems;

            IList<ViajeEN> listaViajes = new ViajeCEN().ReadAll(0, -1);
            IList<SelectListItem> viajesItems = new List<SelectListItem>();

            foreach (ViajeEN via in listaViajes)
            {
                viajesItems.Add(new SelectListItem { Text = via.Id.ToString(), Value = via.Id.ToString() });
            }

            ViewData["Viaje"] = viajesItems;

            return View();
        }

        // POST: Alerta/Create
        [HttpPost]
        public ActionResult Create(AlertaViewModel al)
        {
            try
            {
                // TODO: Add insert logic here
                AlertaCP aler = new AlertaCP();
                aler.New_(al.Tipo,al.Viaje, al.Usuario);

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Alerta/Edit/5
        public ActionResult Edit(int id)
        {
            AlertaCEN aleCEN = new AlertaCEN();

            AlertaViewModel via = new AlertaAssembler().ConvertENToModelUI(aleCEN.ReadOID(id));

            return View(via);
        }

        // POST: Alerta/Edit/5
        [HttpPost]
        public ActionResult Edit(AlertaViewModel ak)
        {
            try
            {
                // TODO: Add update logic here
                AlertaCEN al = new AlertaCEN();
                al.Modify(ak.Id,ak.Tipo);
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Alerta/Delete/5
        public ActionResult Delete(int id)
        {
            SessionInitialize();
            AlertaCAD aleCAD = new AlertaCAD(session);
            AlertaCEN aleCEN = new AlertaCEN(aleCAD);

            AlertaViewModel ale = new AlertaAssembler().ConvertENToModelUI(aleCEN.ReadOID(id));
            SessionClose();
            return View(ale);
        }

        // POST: Alerta/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here
                AlertaCEN aler = new AlertaCEN();
                aler.Destroy(id);
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}