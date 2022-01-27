using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Unicar.Startup))]
namespace Unicar
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
