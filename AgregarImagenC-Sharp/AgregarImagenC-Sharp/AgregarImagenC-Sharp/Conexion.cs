using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Configuration;
namespace AgregarImagenC_Sharp
{
    class Conexion

    {
        public static string Cadena
        {
            get
            {
                string name = "AgregarImagenC-Sharp.Properties.Settings.SqlServer";
                return ConfigurationManager.ConnectionStrings[name].ConnectionString;
            }
        }
    }
}
