
/*PROTECTED REGION ID(CreateDB_imports) ENABLED START*/
using System;
using System.Collections.Generic;
using System.Text;
using System.Data.SqlClient;
using System.Data;
using UnicarGenNHibernate.EN.Unicar;
using UnicarGenNHibernate.CEN.Unicar;
using UnicarGenNHibernate.CAD.Unicar;
using UnicarGenNHibernate.CP.Unicar;
using System.Net;
using System.IO;

/*PROTECTED REGION END*/
namespace InitializeDB
{
public class CreateDB
{
public static void Create (string databaseArg, string userArg, string passArg)
{
        String database = databaseArg;
        String user = userArg;
        String pass = passArg;

        // Conex DB
        SqlConnection cnn = new SqlConnection (@"Server=(local)\sqlexpress; database=master; integrated security=yes");

        // Order T-SQL create user
        String createUser = @"IF NOT EXISTS(SELECT name FROM master.dbo.syslogins WHERE name = '" + user + @"')
            BEGIN
                CREATE LOGIN ["                                                                                                                                     + user + @"] WITH PASSWORD=N'" + pass + @"', DEFAULT_DATABASE=[master], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
            END"                                                                                                                                                                                                                                                                                    ;

        //Order delete user if exist
        String deleteDataBase = @"if exists(select * from sys.databases where name = '" + database + "') DROP DATABASE [" + database + "]";
        //Order create databas
        string createBD = "CREATE DATABASE " + database;
        //Order associate user with database
        String associatedUser = @"USE [" + database + "];CREATE USER [" + user + "] FOR LOGIN [" + user + "];USE [" + database + "];EXEC sp_addrolemember N'db_owner', N'" + user + "'";
        SqlCommand cmd = null;

        try
        {
                // Open conex
                cnn.Open ();

                //Create user in SQLSERVER
                cmd = new SqlCommand (createUser, cnn);
                cmd.ExecuteNonQuery ();

                //DELETE database if exist
                cmd = new SqlCommand (deleteDataBase, cnn);
                cmd.ExecuteNonQuery ();

                //CREATE DB
                cmd = new SqlCommand (createBD, cnn);
                cmd.ExecuteNonQuery ();

                //Associate user with db
                cmd = new SqlCommand (associatedUser, cnn);
                cmd.ExecuteNonQuery ();

                System.Console.WriteLine ("DataBase create sucessfully..");
        }
        catch (Exception ex)
        {
                throw ex;
        }
        finally
        {
                if (cnn.State == ConnectionState.Open) {
                        cnn.Close ();
                }
        }
}

public static void InitializeData ()
{
        /*PROTECTED REGION ID(initializeDataMethod) ENABLED START*/
        try
        {
                // Insert the initilizations of entities using the CEN classes


                // p.e. CustomerCEN customer = new CustomerCEN();
                // customer.New_ (p_user:"user", p_password:"1234");
                UsuarioCEN usuarioCEN = new UsuarioCEN ();
                // String idUsuario1 = usuarioCEN.Registrarse ("admin", "isma", "hola", "ismacb20@gmail.com", "1234", 8.0, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum.Pasajero);

                String idUsuario2 = usuarioCEN.Registrarse ("admin2", "isma2", "hola2", "ismacb20@gmail.com", "1234Hola*", 8.0, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum.Conductor);

                PasajeroCEN pasajeroCEN = new PasajeroCEN ();
                String idPasajero1 = pasajeroCEN.New_ ("admin", "isma", "hola", "ismacb201@gmail.com", "1234", 8.0, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum.Pasajero);

                ConductorCEN conductorCEN = new ConductorCEN ();

                String idConductor1 = conductorCEN.New_ ("conductor1", "isma", "hola", "ismacb202@gmail.com", "1234", 8.0, UnicarGenNHibernate.Enumerated.Unicar.TipoUsuEnum.Conductor, "restriccion");

                VehiculoCEN vehi = new VehiculoCEN ();
                String veh = vehi.New_ ("3456cmg", "seat", "ibiza", idConductor1);

                LocalidadCEN locali = new LocalidadCEN ();
                int loc = 0;

                HttpWebRequest request = (HttpWebRequest)WebRequest.Create (@"https://opendata.aemet.es/opendata/api/maestro/municipios?api_key=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJpc21hY2IyMEBnbWFpbC5jb20iLCJqdGkiOiI0NGNhOWM2NS0yN2I2LTQ1NzAtOTY5Mi0xNDExZDVlNThhMDUiLCJpc3MiOiJBRU1FVCIsImlhdCI6MTYwMTQ1NDEyNSwidXNlcklkIjoiNDRjYTljNjUtMjdiNi00NTcwLTk2OTItMTQxMWQ1ZTU4YTA1Iiwicm9sZSI6IiJ9.0-XuXOiwMpF0v-d2_9VxrcNEhcyNvdvYRyNmxJiH9Uw");
                using (HttpWebResponse response = (HttpWebResponse)request.GetResponse ())
                        using (Stream stream = response.GetResponseStream ())
                                using (StreamReader reader = new StreamReader (stream, Encoding.Default))
                                {
                                        var json = reader.ReadToEnd ();
                                        var localidades = json.Split ('}');
                                        for (int i = 0; i < localidades.Length - 2; i++) {
                                                if (localidades [i].Contains ("nombre")) {
                                                        var propiedades = localidades [i].Split (',');
                                                        var latitud = "";
                                                        var longitud = "";
                                                        var nombre = "";
                                                        var lati = 0.0;
                                                        var lon = 0.0;
                                                        for (int p = 0; p < propiedades.Length - 1; p++) {
                                                                if (propiedades [p].Contains ("latitud_dec")) {
                                                                        latitud = propiedades [p].Split (':') [1];
                                                                        latitud = latitud.Substring (2, latitud.Length - 3);
                                                                        lati = Double.Parse (latitud);
                                                                }
                                                                else if (propiedades [p].Contains ("nombre")) {
                                                                        nombre = propiedades [p].Split (':') [1];
                                                                        nombre = nombre.Substring (2, nombre.Length - 3);


                                                                        //Console.WriteLine(nombre);
                                                                }
                                                                else if (propiedades [p].Contains ("longitud_dec")) {
                                                                        longitud = propiedades [p].Split (':') [1];
                                                                        longitud = longitud.Substring (2, longitud.Length - 3);
                                                                        lon = Double.Parse (longitud);
                                                                        //Console.WriteLine(longitud);
                                                                }
                                                        }
                                                        loc = locali.New_ (nombre, lati, lon);
                                                }
                                        }
                                }


                DireccionCEN direc = new DireccionCEN ();
                int dire = direc.New_ (loc, "Calle Cipote, 23");


                if (usuarioCEN.Login (idPasajero1, "1234") != null) {
                        Console.WriteLine ("Login hecho pasa");
                }

                if (usuarioCEN.Login (idConductor1, "1234") != null) {
                        Console.WriteLine ("Login hecho cond");
                }


                ViajeCEN viajeCEN = new ViajeCEN ();

                int viaje = viajeCEN.New_ (new DateTime (2020, 12, 1), new DateTime (2020, 12, 10), idConductor1, 3, 6.3, veh, dire, dire, 3, new DateTime (2020, 10, 5, 14, 00, 00), new DateTime (2020, 10, 5, 14, 00, 00));
                int viaje1 = viajeCEN.New_ (new DateTime (2020, 12, 1), new DateTime (2020, 12, 10), idConductor1, 3, 6.3, veh, dire, dire, 0, new DateTime (2020, 10, 5, 14, 00, 00), new DateTime (2020, 10, 5, 14, 00, 00));

                if (viaje != -2) {
                        Console.WriteLine ("Viaje creado");
                }

                ViajeCP via = new ViajeCP ();

                Console.WriteLine ("Reservas viaje: " + viajeCEN.ReadOID (viaje).Plazasocupadas);

                via.ReservarViaje (viaje, idPasajero1);

                Console.WriteLine ("Reservas viaje: " + viajeCEN.ReadOID (viaje).Plazasocupadas);

                ConductorCP cond = new ConductorCP ();

                Console.WriteLine ("Viajes pasajero: " + viajeCEN.BuscarViajePorPasajero (idPasajero1).Count);

                /*PROTECTED REGION END*/
        }
        catch (Exception ex)
        {
                System.Console.WriteLine (ex.InnerException);
                throw ex;
        }
}
}
}
