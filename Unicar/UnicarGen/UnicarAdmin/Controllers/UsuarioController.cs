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

    public class UsuarioController : BasicController
    {
        // GET: Usuario
        public ActionResult Index(string searchString)
        {
            SessionInitialize();
            UsuarioCAD usuCAD = new UsuarioCAD(session);
            UsuarioCEN usuCEN = new UsuarioCEN(usuCAD);

            IList<UsuarioEN> listEN = usuCEN.ReadAll(0, -1);
            IEnumerable<UsuarioViewModel> ListViewModel = new UsuarioAssembler().ConvertListENToModel(listEN).ToList();
            if (!String.IsNullOrEmpty(searchString))
            {
                ListViewModel = ListViewModel.Where(s => s.Nombre_usuario.ToLower().Contains(searchString.ToLower()));
            }
            SessionClose();

            return View(ListViewModel);
        }

        // GET: Usuario/Details/5
        public ActionResult Details(string id)
        {
            SessionInitialize();
            UsuarioCAD usuCAD = new UsuarioCAD(session);
            UsuarioCEN usuCEN = new UsuarioCEN(usuCAD);

            UsuarioViewModel pasV = new UsuarioAssembler().ConvertENToModelUI(usuCEN.ReadOID(id));
            SessionClose();
            return View(pasV);
        }

        // GET: Usuario/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Usuario/Create
        [HttpPost]
        public ActionResult Create(UsuarioViewModel usu)
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

        // GET: Usuario/Edit/5
        public ActionResult Edit(string id)
        {

           
            return View();
        }

        // POST: Usuario/Edit/5
        [HttpPost]
        public ActionResult Edit(UsuarioViewModel usu)
        {
            try
            {
                // TODO: Add update logic here
                

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Usuario/Delete/5
        public ActionResult Delete(string id)
        {
            


            return View();
        }

        // POST: Usuario/Delete/5
        [HttpPost]
        public ActionResult Delete(string id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here 
                

                return RedirectToAction("Index");
            }
            catch (Exception e)
            {
                return View(e.Message);
            }
        }
    }
}