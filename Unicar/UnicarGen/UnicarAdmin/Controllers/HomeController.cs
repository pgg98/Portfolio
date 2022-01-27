using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using UnicarGenNHibernate.CEN.Unicar;
using UnicarGenNHibernate.EN.Unicar;

namespace UnicarAdmin.Controllers
{
    [Authorize (Users ="unicar@gmail.com")]
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult About()
        {
            ViewBag.Message = "La página que buscabas para ir la Universidad.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}