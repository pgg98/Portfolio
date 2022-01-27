using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(UnicarAdmin.Startup))]
namespace UnicarAdmin
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
