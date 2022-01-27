function GetMap() {
    

    //Aquí voy a intentar filtrar los municipios

     var datos;
     var datosfiltrados = [];
     var key = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZ2c5OEBnY2xvdWQudWEuZXMiLCJqdGkiOiI5YzFkMmMwNS1jY2U2LTRkNjItYjc4MC1jNWRmMGVkMzdjODUiLCJpc3MiOiJBRU1FVCIsImlhdCI6MTYwNTI5MzE3MCwidXNlcklkIjoiOWMxZDJjMDUtY2NlNi00ZDYyLWI3ODAtYzVkZjBlZDM3Yzg1Iiwicm9sZSI6IiJ9.0n-mHTFJfPDSJgvA4MBFaZmz03r2dFdQwu9cn9Y7Rls';
     //He metido la key de AEMET pero alomejor es la bing maps no lo sé
     var settings = {
        "async": true,
        "crossDomain": true,
        "url": "https://opendata.aemet.es/opendata/api/maestro/municipios?api_key=" + key,
        "method": "GET",
        "headers": {
            "cache-control": "no-cache"
        }
     }

     $(document).on("pagecreate", "#index", function (event) {
        InicializarGrid();
     });
     
     //function InicializarGrid() {
     $.ajax(settings).done(function (response) {
         var map = new Microsoft.Maps.Map('#myMap', {
             credentials: 'ApkeRpgiQvqtskwQO8hfv2UypzGq1ithCgpolJ9eKHJxoHxLYxci1HtNVILp_01d'
         });

         var j = 0;
         //Parseo a objeto para filtrar y meter en datatable
         datos = JSON.parse(response);

         //console(datos[0]);  Esto no funciona no se pq y lo necesito para ver como coger el nombre para el infobox
         //Filtro los municipios con altitud inferior a 200m
         for (let i = 0; i < datos.length; i++) {
             if (datos[i].altitud < 200) {
                 navigator.geolocation.getCurrentPosition(function (position) {
                     var loc = new Microsoft.Maps.Location(datos[i].latitud_dec, datos[i].longitud_dec);
                     //Añado marcador en la posición obtenido del usuario.
                     var pin = new Microsoft.Maps.Pushpin(loc);
                     map.entities.push(pin);
                     //Centro el mapa en la posición obtenida del usuario.
                     //map.setView({ center: loc, zoom: 6 });

                     //Aquí añadimos la caja con información
                     var center = map.getCenter();

                     Microsoft.Maps.Events.addHandler(pin, 'click', function () {
                         var infobox = new Microsoft.Maps.Infobox(center, { title: datos[i].nombre, description: "Altitud: " + datos[i].altitud + " m" }); //El nombre esta mal falta corregirlo
                         infobox.setMap(map);
                     });
                 });

                 //Aquí añadimos la caja con información
                 //var map = new Microsoft.Maps.Map(document.getElementById('myMap'), {
                 /* No need to set credentials if already passed in URL */
                 //center: new Microsoft.Maps.Location(47.60357, -122.32945)
                 //});  
             }
         }
     });
};

function GetEstaciones() {
    var datos;
    var cosas;
    var datosfiltrados = [];
    var key = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZ2c5OEBnY2xvdWQudWEuZXMiLCJqdGkiOiI5YzFkMmMwNS1jY2U2LTRkNjItYjc4MC1jNWRmMGVkMzdjODUiLCJpc3MiOiJBRU1FVCIsImlhdCI6MTYwNTI5MzE3MCwidXNlcklkIjoiOWMxZDJjMDUtY2NlNi00ZDYyLWI3ODAtYzVkZjBlZDM3Yzg1Iiwicm9sZSI6IiJ9.0n-mHTFJfPDSJgvA4MBFaZmz03r2dFdQwu9cn9Y7Rls';
    //He metido la key de AEMET pero alomejor es la bing maps no lo sé
    var settings = {
        "async": true,
        "crossDomain": true,
        "url": "https://opendata.aemet.es/opendata/api/valores/climatologicos/inventarioestaciones/todasestaciones?api_key=" + key,
        "method": "GET",
        "headers": {
            "cache-control": "no-cache"
        }
    }

    $(document).on("pagecreate", "#index", function (event) {
        InicializarGrid();
    });

    $.ajax(settings).done(function (response) {
        var j = 0;

        var ajustes = {
            "async": true,
            "crossDomain": true,
            "url": response.datos,
            "method": "GET",
            "headers": {
                "cache-control": "no-cache"
            }
        }


        $.ajax(ajustes).done(function (response) {
            cosas = JSON.parse(response);

            cosas.forEach(function (entry) {
                
                datosfiltrados[j] = entry;
                j = j + 1;
                
            });
            tabla = $('#dataGrid').DataTable({
                "data": datosfiltrados,
                "columns": [
                    {
                        "data": "nombre"
                    }
                ]
            });

        });
    });
};

function tiempo() {
    var map2 = new Microsoft.Maps.Map('#mapa2', {
        credentials: 'ApkeRpgiQvqtskwQO8hfv2UypzGq1ithCgpolJ9eKHJxoHxLYxci1HtNVILp_01d'
    });

    var datos;
    var iconito;
    //var datosAlc;
    var datosfiltrados = [];
    var key = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZ2c5OEBnY2xvdWQudWEuZXMiLCJqdGkiOiI5YzFkMmMwNS1jY2U2LTRkNjItYjc4MC1jNWRmMGVkMzdjODUiLCJpc3MiOiJBRU1FVCIsImlhdCI6MTYwNTI5MzE3MCwidXNlcklkIjoiOWMxZDJjMDUtY2NlNi00ZDYyLWI3ODAtYzVkZjBlZDM3Yzg1Iiwicm9sZSI6IiJ9.0n-mHTFJfPDSJgvA4MBFaZmz03r2dFdQwu9cn9Y7Rls';

    /*$(document).on("pagecreate", "#index", function (event) {
        InicializarGrid();
    });*/


    //Alicante
    var settingsAlicante = {
        "async": true,
        "crossDomain": true,
        "url": "https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/03014?api_key=" + key,
        "method": "GET",
        "headers": {
            "cache-control": "no-cache"
        }
    }

    $.ajax(settingsAlicante).done(function (response) {

        var j = 0;

        var settingsAlicante2 = {
            "async": true,
            "crossDomain": true,
            "url": response.datos,
            "method": "GET",
            "headers": {
                "cache-control": "no-cache"
            }
        }

        $.ajax(settingsAlicante2).done(function (response) {
            var datosAlc2 = JSON.parse(response);
            //Guardarme los datos que me interesan

            var estado = datosAlc2[0].prediccion.dia[0].estadoCielo;
            var bientoDir = "awacate";
            var a = false;
            for (var i = 0; i < datosAlc2[0].prediccion.dia[0].viento.length && a == false; i++) {
                if (datosAlc2[0].prediccion.dia[0].viento[i].direccion != null && datosAlc2[0].prediccion.dia[0].viento[i].direccion != "") {
                    bientoDir = datosAlc2[0].prediccion.dia[0].viento[i].direccion;
                    a = true;
                }
            }

            var bientoVel = "awacate";
            var b = false;
            for (var i = 0; i < datosAlc2[0].prediccion.dia[0].viento.length && b == false; i++) {
                if (datosAlc2[0].prediccion.dia[0].viento[i].velocidad != null && datosAlc2[0].prediccion.dia[0].viento[i].velocidad != "") {
                    bientoVel = datosAlc2[0].prediccion.dia[0].viento[i].velocidad;
                    b = true;
                }
            }

            /*var tempMax = "awacate";
            var c = false;
            for (var i = 0; i < datosAlc2[0].prediccion.dia[0].temperatura.length && c == false; i++) {
                if (datosAlc2[0].prediccion.dia[0].temperatura[i].maxima != null && datosAlc2[0].prediccion.dia[0].temperatura[i].maxima != "") {
                    tempMax = datosAlc2[0].prediccion.dia[0].temperatura[i].maxima;
                    c = true;
                }
            }

            var tempMin = "awacate";
            var d = false;
            for (var i = 0; i < datosAlc2[0].prediccion.dia[0].temperatura.length && d == false; i++) {
                if (datosAlc2[0].prediccion.dia[0].temperatura[i].minima != null && datosAlc2[0].prediccion.dia[0].temperatura[i].minima != "") {
                    tempMin = datosAlc2[0].prediccion.dia[0].temperatura[i].minima;
                    d = true;
                }
            }*/

            var estado=datosAlc2[0].prediccion.dia[0].estadoCielo;
            
            //Para saber la localizacion
            var settingsAlicante3 = {
                "async": true,
                "crossDomain": true,
                "url": "https://opendata.aemet.es/opendata/api/maestro/municipio/id03014?api_key=" + key,
                "method": "GET",
                "headers": {
                    "cache-control": "no-cache"
                }
            }

            $.ajax(settingsAlicante3).done(function (response) {
                var datosAlc = JSON.parse(response);

                var nomvre = datosAlc[0].nombre;

                navigator.geolocation.getCurrentPosition(function (position) {
                    var loc = new Microsoft.Maps.Location(datosAlc[0].latitud_dec, datosAlc[0].longitud_dec);
                    //Añado marcador en la posición obtenido del usuario.
                    if (estado == "Despejado" || estado == "Despejado noche") {
                        //pongo sol
                        iconito = 'images/solecito.png';
                    } else if (estado == "Nuboso" || estado == "Muy nuboso" || estado == "Nuboso noche" || estado == "Muy nuboso noche") {
                        //pongo nubes
                        iconito = 'images/nublado.png';
                    } else {
                        //pongo lluvia
                        iconito = 'images/nubecita.png';
                    }

                    var pin2 = new Microsoft.Maps.Pushpin(loc, { icon:iconito });
                    map2.entities.push(pin2);
                   
                    //Centro el mapa en la posición obtenida del usuario.
                    map2.setView({ center: loc, zoom: 6 });

                    //Aquí añadimos la caja con información
                    var center = map2.getCenter();

                    Microsoft.Maps.Events.addHandler(pin2, 'click', function () {
                        var infobox = new Microsoft.Maps.Infobox(loc, { title: nomvre, description: "<p>Direccion del viento: </p>" + bientoDir + "<p>Velocidad del viento: </p>" + bientoVel /*+ "<p>Temperatura maxima: </p>" + tempMax + "<p>Temperatura minima: </p>" + tempMin*/ });
                        infobox.setMap(map2);
                    });
                });
            });
        });
    });

    
    //Valencia
    var settingsValencia = {
        "async": true,
        "crossDomain": true,
        "url": "https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/46250?api_key=" + key,
        "method": "GET",
        "headers": {
            "cache-control": "no-cache"
        }
    }

    $.ajax(settingsValencia).done(function (response) {

        var j = 0;

        var settingsValencia2 = {
            "async": true,
            "crossDomain": true,
            "url": response.datos,
            "method": "GET",
            "headers": {
                "cache-control": "no-cache"
            }
        }

        $.ajax(settingsValencia2).done(function (response) {
            var datosValencia2 = JSON.parse(response);
            //Guardarme los datos que me interesan

            var estado = datosValencia2[0].prediccion.dia[0].estadoCielo;
            var bientoDir = "awacate";
            var a = false;
            for (var i = 0; i < datosValencia2[0].prediccion.dia[0].viento.length && a == false; i++) {
                if (datosValencia2[0].prediccion.dia[0].viento[i].direccion != null && datosValencia2[0].prediccion.dia[0].viento[i].direccion != "") {
                    bientoDir = datosValencia2[0].prediccion.dia[0].viento[i].direccion;
                    a = true;
                }
            }

            var bientoVel = "awacate";
            var b = false;
            for (var i = 0; i < datosValencia2[0].prediccion.dia[0].viento.length && b == false; i++) {
                if (datosValencia2[0].prediccion.dia[0].viento[i].velocidad != null && datosValencia2[0].prediccion.dia[0].viento[i].velocidad != "") {
                    bientoVel = datosValencia2[0].prediccion.dia[0].viento[i].velocidad;
                    b = true;
                }
            }

            var estado = datosValencia2[0].prediccion.dia[0].estadoCielo;

            //Para saber la localizacion
            var settingsValencia3 = {
                "async": true,
                "crossDomain": true,
                "url": "https://opendata.aemet.es/opendata/api/maestro/municipio/id46250?api_key=" + key,
                "method": "GET",
                "headers": {
                    "cache-control": "no-cache"
                }
            }

            $.ajax(settingsValencia3).done(function (response) {
                var datosValencia = JSON.parse(response);

                var nomvre = datosValencia[0].nombre;

                navigator.geolocation.getCurrentPosition(function (position) {
                    var loc = new Microsoft.Maps.Location(datosValencia[0].latitud_dec, datosValencia[0].longitud_dec);
                    //Añado marcador en la posición obtenido del usuario.
                    if (estado == "Despejado" || estado == "Despejado noche") {
                        //pongo sol
                        iconito = 'images/solecito.png';
                    } else if (estado == "Nuboso" || estado == "Muy nuboso" || estado == "Nuboso noche" || estado == "Muy nuboso noche") {
                        //pongo nubes
                        iconito = 'images/nublado.png';
                    } else {
                        //pongo lluvia
                        iconito = 'images/nubecita.png';
                    }

                    var pin2 = new Microsoft.Maps.Pushpin(loc, { icon: iconito });
                    map2.entities.push(pin2);

                    //Centro el mapa en la posición obtenida del usuario.
                    map2.setView({ center: loc, zoom: 6 });

                    //Aquí añadimos la caja con información
                    var center = map2.getCenter();

                    Microsoft.Maps.Events.addHandler(pin2, 'click', function () {
                        var infobox = new Microsoft.Maps.Infobox(loc, { title: nomvre, description: "<p>Direccion del viento: </p>" + bientoDir + "<p>Velocidad del viento: </p>" + bientoVel /*+ "<p>Temperatura maxima: </p>" + tempMax + "<p>Temperatura minima: </p>" + tempMin*/ });
                        infobox.setMap(map2);
                    });
                });
            });
        });
    });


    //Castellon
    var settingsCastellon = {
        "async": true,
        "crossDomain": true,
        "url": "https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/12040?api_key=" + key,
        "method": "GET",
        "headers": {
            "cache-control": "no-cache"
        }
    }

    $.ajax(settingsCastellon).done(function (response) {

        var j = 0;

        var settingsCastellon2 = {
            "async": true,
            "crossDomain": true,
            "url": response.datos,
            "method": "GET",
            "headers": {
                "cache-control": "no-cache"
            }
        }

        $.ajax(settingsCastellon2).done(function (response) {
            var datosCastellon2 = JSON.parse(response);
            //Guardarme los datos que me interesan

            var estado = datosCastellon2[0].prediccion.dia[0].estadoCielo;
            var bientoDir = "awacate";
            var a = false;
            for (var i = 0; i < datosCastellon2[0].prediccion.dia[0].viento.length && a == false; i++) {
                if (datosCastellon2[0].prediccion.dia[0].viento[i].direccion != null && datosCastellon2[0].prediccion.dia[0].viento[i].direccion != "") {
                    bientoDir = datosCastellon2[0].prediccion.dia[0].viento[i].direccion;
                    a = true;
                }
            }

            var bientoVel = "awacate";
            var b = false;
            for (var i = 0; i < datosCastellon2[0].prediccion.dia[0].viento.length && b == false; i++) {
                if (datosCastellon2[0].prediccion.dia[0].viento[i].velocidad != null && datosCastellon2[0].prediccion.dia[0].viento[i].velocidad != "") {
                    bientoVel = datosCastellon2[0].prediccion.dia[0].viento[i].velocidad;
                    b = true;
                }
            }

            var estado = datosCastellon2[0].prediccion.dia[0].estadoCielo;

            //Para saber la localizacion
            var settingsCastellon3 = {
                "async": true,
                "crossDomain": true,
                "url": "https://opendata.aemet.es/opendata/api/maestro/municipio/id12040?api_key=" + key,
                "method": "GET",
                "headers": {
                    "cache-control": "no-cache"
                }
            }

            $.ajax(settingsCastellon3).done(function (response) {
                var datosCastellon = JSON.parse(response);

                var nomvre = datosCastellon[0].nombre;

                navigator.geolocation.getCurrentPosition(function (position) {
                    var loc = new Microsoft.Maps.Location(datosCastellon[0].latitud_dec, datosCastellon[0].longitud_dec);
                    //Añado marcador en la posición obtenido del usuario.
                    if (estado == "Despejado" || estado == "Despejado noche") {
                        //pongo sol
                        iconito = 'images/solecito.png';
                    } else if (estado == "Nuboso" || estado == "Muy nuboso" || estado == "Nuboso noche" || estado == "Muy nuboso noche") {
                        //pongo nubes
                        iconito = 'images/nublado.png';
                    } else {
                        //pongo lluvia
                        iconito = 'images/nubecita.png';
                    }

                    var pin2 = new Microsoft.Maps.Pushpin(loc, { icon: iconito });
                    map2.entities.push(pin2);

                    //Centro el mapa en la posición obtenida del usuario.
                    map2.setView({ center: loc, zoom: 6 });

                    //Aquí añadimos la caja con información
                    var center = map2.getCenter();

                    Microsoft.Maps.Events.addHandler(pin2, 'click', function () {
                        var infobox = new Microsoft.Maps.Infobox(loc, { title: nomvre, description: "<p>Direccion del viento: </p>" + bientoDir + "<p>Velocidad del viento: </p>" + bientoVel /*+ "<p>Temperatura maxima: </p>" + tempMax + "<p>Temperatura minima: </p>" + tempMin*/ });
                        infobox.setMap(map2);
                    });
                });
            });
        });
    });


    //Alcoy
    var settingsAlcoy = {
        "async": true,
        "crossDomain": true,
        "url": "https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/03009?api_key=" + key,
        "method": "GET",
        "headers": {
            "cache-control": "no-cache"
        }
    }

    $.ajax(settingsAlcoy).done(function (response) {

        var j = 0;

        var settingsAlcoy2 = {
            "async": true,
            "crossDomain": true,
            "url": response.datos,
            "method": "GET",
            "headers": {
                "cache-control": "no-cache"
            }
        }

        $.ajax(settingsAlcoy2).done(function (response) {
            var datosAlcoy2 = JSON.parse(response);
            //Guardarme los datos que me interesan

            var estado = datosAlcoy2[0].prediccion.dia[0].estadoCielo;
            var bientoDir = "awacate";
            var a = false;
            for (var i = 0; i < datosAlcoy2[0].prediccion.dia[0].viento.length && a == false; i++) {
                if (datosAlcoy2[0].prediccion.dia[0].viento[i].direccion != null && datosAlcoy2[0].prediccion.dia[0].viento[i].direccion != "") {
                    bientoDir = datosAlcoy2[0].prediccion.dia[0].viento[i].direccion;
                    a = true;
                }
            }

            var bientoVel = "awacate";
            var b = false;
            for (var i = 0; i < datosAlcoy2[0].prediccion.dia[0].viento.length && b == false; i++) {
                if (datosAlcoy2[0].prediccion.dia[0].viento[i].velocidad != null && datosAlcoy2[0].prediccion.dia[0].viento[i].velocidad != "") {
                    bientoVel = datosAlcoy2[0].prediccion.dia[0].viento[i].velocidad;
                    b = true;
                }
            }

            var estado = datosAlcoy2[0].prediccion.dia[0].estadoCielo;

            //Para saber la localizacion
            var settingsAlcoy3 = {
                "async": true,
                "crossDomain": true,
                "url": "https://opendata.aemet.es/opendata/api/maestro/municipio/id03009?api_key=" + key,
                "method": "GET",
                "headers": {
                    "cache-control": "no-cache"
                }
            }

            $.ajax(settingsAlcoy3).done(function (response) {
                var datosAlcoy = JSON.parse(response);

                var nomvre = datosAlcoy[0].nombre;

                navigator.geolocation.getCurrentPosition(function (position) {
                    var loc = new Microsoft.Maps.Location(datosAlcoy[0].latitud_dec, datosAlcoy[0].longitud_dec);
                    //Añado marcador en la posición obtenido del usuario.
                    if (estado == "Despejado" || estado == "Despejado noche") {
                        //pongo sol
                        iconito = 'images/solecito.png';
                    } else if (estado == "Nuboso" || estado == "Muy nuboso" || estado == "Nuboso noche" || estado == "Muy nuboso noche") {
                        //pongo nubes
                        iconito = 'images/nublado.png';
                    } else {
                        //pongo lluvia
                        iconito = 'images/nubecita.png';
                    }

                    var pin2 = new Microsoft.Maps.Pushpin(loc, { icon: iconito });
                    map2.entities.push(pin2);

                    //Centro el mapa en la posición obtenida del usuario.
                    map2.setView({ center: loc, zoom: 6 });

                    //Aquí añadimos la caja con información
                    var center = map2.getCenter();

                    Microsoft.Maps.Events.addHandler(pin2, 'click', function () {
                        var infobox = new Microsoft.Maps.Infobox(loc, { title: nomvre, description: "<p>Direccion del viento: </p>" + bientoDir + "<p>Velocidad del viento: </p>" + bientoVel /*+ "<p>Temperatura maxima: </p>" + tempMax + "<p>Temperatura minima: </p>" + tempMin*/ });
                        infobox.setMap(map2);
                    });
                });
            });
        });
    });



    //SanVicente
    var settingsSanVicente = {
        "async": true,
        "crossDomain": true,
        "url": "https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/03122?api_key=" + key,
        "method": "GET",
        "headers": {
            "cache-control": "no-cache"
        }
    }

    $.ajax(settingsSanVicente).done(function (response) {

        var j = 0;

        var settingsSanVicente2 = {
            "async": true,
            "crossDomain": true,
            "url": response.datos,
            "method": "GET",
            "headers": {
                "cache-control": "no-cache"
            }
        }

        $.ajax(settingsSanVicente2).done(function (response) {
            var datosSanVicente2 = JSON.parse(response);
            //Guardarme los datos que me interesan

            var estado = datosSanVicente2[0].prediccion.dia[0].estadoCielo;
            var bientoDir = "awacate";
            var a = false;
            for (var i = 0; i < datosSanVicente2[0].prediccion.dia[0].viento.length && a == false; i++) {
                if (datosSanVicente2[0].prediccion.dia[0].viento[i].direccion != null && datosSanVicente2[0].prediccion.dia[0].viento[i].direccion != "") {
                    bientoDir = datosSanVicente2[0].prediccion.dia[0].viento[i].direccion;
                    a = true;
                }
            }

            var bientoVel = "awacate";
            var b = false;
            for (var i = 0; i < datosSanVicente2[0].prediccion.dia[0].viento.length && b == false; i++) {
                if (datosSanVicente2[0].prediccion.dia[0].viento[i].velocidad != null && datosSanVicente2[0].prediccion.dia[0].viento[i].velocidad != "") {
                    bientoVel = datosSanVicente2[0].prediccion.dia[0].viento[i].velocidad;
                    b = true;
                }
            }

            var estado = datosSanVicente2[0].prediccion.dia[0].estadoCielo;

            //Para saber la localizacion
            var settingsSanVicente3 = {
                "async": true,
                "crossDomain": true,
                "url": "https://opendata.aemet.es/opendata/api/maestro/municipio/id03122?api_key=" + key,
                "method": "GET",
                "headers": {
                    "cache-control": "no-cache"
                }
            }

            $.ajax(settingsSanVicente3).done(function (response) {
                var datosSanVicente = JSON.parse(response);

                var nomvre = datosSanVicente[0].nombre;

                navigator.geolocation.getCurrentPosition(function (position) {
                    var loc = new Microsoft.Maps.Location(datosSanVicente[0].latitud_dec, datosSanVicente[0].longitud_dec);
                    //Añado marcador en la posición obtenido del usuario.
                    if (estado == "Despejado" || estado == "Despejado noche") {
                        //pongo sol
                        iconito = 'images/solecito.png';
                    } else if (estado == "Nuboso" || estado == "Muy nuboso" || estado == "Nuboso noche" || estado == "Muy nuboso noche") {
                        //pongo nubes
                        iconito = 'images/nublado.png';
                    } else {
                        //pongo lluvia
                        iconito = 'images/nubecita.png';
                    }

                    var pin2 = new Microsoft.Maps.Pushpin(loc, { icon: iconito });
                    map2.entities.push(pin2);

                    //Centro el mapa en la posición obtenida del usuario.
                    map2.setView({ center: loc, zoom: 6 });

                    //Aquí añadimos la caja con información
                    var center = map2.getCenter();

                    Microsoft.Maps.Events.addHandler(pin2, 'click', function () {
                        var infobox = new Microsoft.Maps.Infobox(loc, { title: nomvre, description: "<p>Direccion del viento: </p>" + bientoDir + "<p>Velocidad del viento: </p>" + bientoVel /*+ "<p>Temperatura maxima: </p>" + tempMax + "<p>Temperatura minima: </p>" + tempMin*/ });
                        infobox.setMap(map2);
                    });
                });
            });
        });
    });

    //Villena 
    var settingsVillena = {
        "async": true,
        "crossDomain": true,
        "url": "https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/03140?api_key=" + key,
        "method": "GET",
        "headers": {
            "cache-control": "no-cache"
        }
    }

    $.ajax(settingsVillena).done(function (response) {

        var j = 0;

        var settingsVillena2 = {
            "async": true,
            "crossDomain": true,
            "url": response.datos,
            "method": "GET",
            "headers": {
                "cache-control": "no-cache"
            }
        }

        $.ajax(settingsVillena2).done(function (response) {
            var datosVillena2 = JSON.parse(response);
            //Guardarme los datos que me interesan

            var estado = datosVillena2[0].prediccion.dia[0].estadoCielo;
            var bientoDir = "awacate";
            var a = false;
            for (var i = 0; i < datosVillena2[0].prediccion.dia[0].viento.length && a == false; i++) {
                if (datosVillena2[0].prediccion.dia[0].viento[i].direccion != null && datosVillena2[0].prediccion.dia[0].viento[i].direccion != "") {
                    bientoDir = datosVillena2[0].prediccion.dia[0].viento[i].direccion;
                    a = true;
                }
            }

            var bientoVel = "awacate";
            var b = false;
            for (var i = 0; i < datosVillena2[0].prediccion.dia[0].viento.length && b == false; i++) {
                if (datosVillena2[0].prediccion.dia[0].viento[i].velocidad != null && datosVillena2[0].prediccion.dia[0].viento[i].velocidad != "") {
                    bientoVel = datosVillena2[0].prediccion.dia[0].viento[i].velocidad;
                    b = true;
                }
            }

            var estado = datosVillena2[0].prediccion.dia[0].estadoCielo;

            //Para saber la localizacion
            var settingsVillena3 = {
                "async": true,
                "crossDomain": true,
                "url": "https://opendata.aemet.es/opendata/api/maestro/municipio/id03140?api_key=" + key,
                "method": "GET",
                "headers": {
                    "cache-control": "no-cache"
                }
            }

            $.ajax(settingsVillena3).done(function (response) {
                var datosVillena = JSON.parse(response);

                var nomvre = datosVillena[0].nombre;

                navigator.geolocation.getCurrentPosition(function (position) {
                    var loc = new Microsoft.Maps.Location(datosVillena[0].latitud_dec, datosVillena[0].longitud_dec);
                    //Añado marcador en la posición obtenido del usuario.
                    if (estado == "Despejado" || estado == "Despejado noche") {
                        //pongo sol
                        iconito = 'images/solecito.png';
                    } else if (estado == "Nuboso" || estado == "Muy nuboso" || estado == "Nuboso noche" || estado == "Muy nuboso noche") {
                        //pongo nubes
                        iconito = 'images/nublado.png';
                    } else {
                        //pongo lluvia
                        iconito = 'images/nubecita.png';
                    }

                    var pin2 = new Microsoft.Maps.Pushpin(loc, { icon: iconito });
                    map2.entities.push(pin2);

                    //Centro el mapa en la posición obtenida del usuario.
                    map2.setView({ center: loc, zoom: 6 });

                    //Aquí añadimos la caja con información
                    var center = map2.getCenter();

                    Microsoft.Maps.Events.addHandler(pin2, 'click', function () {
                        var infobox = new Microsoft.Maps.Infobox(loc, { title: nomvre, description: "<p>Direccion del viento: </p>" + bientoDir + "<p>Velocidad del viento: </p>" + bientoVel /*+ "<p>Temperatura maxima: </p>" + tempMax + "<p>Temperatura minima: </p>" + tempMin*/ });
                        infobox.setMap(map2);
                    });
                });
            });
        });
    });


    //Denia 
    var settingsDenia = {
        "async": true,
        "crossDomain": true,
        "url": "https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/03063?api_key=" + key,
        "method": "GET",
        "headers": {
            "cache-control": "no-cache"
        }
    }

    $.ajax(settingsDenia).done(function (response) {

        var j = 0;

        var settingsDenia2 = {
            "async": true,
            "crossDomain": true,
            "url": response.datos,
            "method": "GET",
            "headers": {
                "cache-control": "no-cache"
            }
        }

        $.ajax(settingsDenia2).done(function (response) {
            var datosDenia2 = JSON.parse(response);
            //Guardarme los datos que me interesan

            var estado = datosDenia2[0].prediccion.dia[0].estadoCielo;
            var bientoDir="awacate";
            var a = false;
            for (var i= 0; i < datosDenia2[0].prediccion.dia[0].viento.length && a==false; i++){
                if (datosDenia2[0].prediccion.dia[0].viento[i].direccion != null && datosDenia2[0].prediccion.dia[0].viento[i].direccion != "") {
                    bientoDir = datosDenia2[0].prediccion.dia[0].viento[i].direccion;
                    a = true;
                }   
            }

            var bientoVel = "awacate";
            var b = false;
            for (var i = 0; i < datosDenia2[0].prediccion.dia[0].viento.length && b == false; i++) {
                if (datosDenia2[0].prediccion.dia[0].viento[i].velocidad != null && datosDenia2[0].prediccion.dia[0].viento[i].velocidad != "") {
                    bientoVel = datosDenia2[0].prediccion.dia[0].viento[i].velocidad;
                    b = true;
                }
            }

            var tempMax = "awacate";
            var c = false;
            for (var i = 0; i < datosDenia2[0].prediccion.dia[0].temperatura.length && c == false; i++) {
                if (datosDenia2[0].prediccion.dia[0].temperatura[i].maxima != null && datosDenia2[0].prediccion.dia[0].temperatura[i].maxima != "") {
                    tempMax = datosDenia2[0].prediccion.dia[0].temperatura[i].maxima;
                    c = true;
                }
            }

            var tempMin = "awacate";
            var d = false;
            for (var i = 0; i < datosDenia2[0].prediccion.dia[0].temperatura.length && d == false; i++) {
                if (datosDenia2[0].prediccion.dia[0].temperatura[i].minima != null && datosDenia2[0].prediccion.dia[0].temperatura[i].minima != "") {
                    tempMin = datosDenia2[0].prediccion.dia[0].temperatura[i].minima;
                    d = true;
                }
            }

            //console.log(bientoDir);

            //Para saber la localizacion
            var settingsDenia3 = {
                "async": true,
                "crossDomain": true,
                "url": "https://opendata.aemet.es/opendata/api/maestro/municipio/id03063?api_key=" + key,
                "method": "GET",
                "headers": {
                    "cache-control": "no-cache"
                }
            }

            $.ajax(settingsDenia3).done(function (response) {
                var datosDenia = JSON.parse(response);

                var nomvre = datosDenia[0].nombre;

                navigator.geolocation.getCurrentPosition(function (position) {
                    var loc = new Microsoft.Maps.Location(datosDenia[0].latitud_dec, datosDenia[0].longitud_dec);
                    //Añado marcador en la posición obtenido del usuario.
                    if (estado == "Despejado" || estado == "Despejado noche") {
                        //pongo sol
                        iconito = 'images/solecito.png';
                    } else if (estado == "Nuboso" || estado == "Muy nuboso" || estado == "Nuboso noche" || estado == "Muy nuboso noche") {
                        //pongo nubes
                        iconito = 'images/nublado.png';
                    } else {
                        //pongo lluvia
                        iconito = 'images/nubecita.png';
                    }

                    var pin2 = new Microsoft.Maps.Pushpin(loc, { icon: iconito });
                    map2.entities.push(pin2);

                    //Centro el mapa en la posición obtenida del usuario.
                    map2.setView({ center: loc, zoom: 6 });

                    //Aquí añadimos la caja con información
                    var center = map2.getCenter();

                    Microsoft.Maps.Events.addHandler(pin2, 'click', function () {
                        var infobox = new Microsoft.Maps.Infobox(loc, { title: nomvre, description: "<p>Direccion del viento: </p>" + bientoDir + "<p>Velocidad del viento: </p>" + bientoVel /*+ "<p>Temperatura maxima: </p>" + tempMax + "<p>Temperatura minima: </p>" + tempMin*/});
                        infobox.setMap(map2);
                    });
                });
            });
        });
    });


    //Orihuela
    var settingsOrihuela = {
        "async": true,
        "crossDomain": true,
        "url": "https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/03099?api_key=" + key,
        "method": "GET",
        "headers": {
            "cache-control": "no-cache"
        }
    }

    $.ajax(settingsOrihuela).done(function (response) {

        var j = 0;

        var settingsOrihuela2 = {
            "async": true,
            "crossDomain": true,
            "url": response.datos,
            "method": "GET",
            "headers": {
                "cache-control": "no-cache"
            }
        }

        $.ajax(settingsOrihuela2).done(function (response) {
            var datosOrihuela2 = JSON.parse(response);
            //Guardarme los datos que me interesan

            var estado = datosOrihuela2[0].prediccion.dia[0].estadoCielo;
            var bientoDir = "awacate";
            var a = false;
            for (var i = 0; i < datosOrihuela2[0].prediccion.dia[0].viento.length && a == false; i++) {
                if (datosOrihuela2[0].prediccion.dia[0].viento[i].direccion != null && datosOrihuela2[0].prediccion.dia[0].viento[i].direccion != "") {
                    bientoDir = datosOrihuela2[0].prediccion.dia[0].viento[i].direccion;
                    a = true;
                }
            }

            var bientoVel = "awacate";
            var b = false;
            for (var i = 0; i < datosOrihuela2[0].prediccion.dia[0].viento.length && b == false; i++) {
                if (datosOrihuela2[0].prediccion.dia[0].viento[i].velocidad != null && datosOrihuela2[0].prediccion.dia[0].viento[i].velocidad != "") {
                    bientoVel = datosOrihuela2[0].prediccion.dia[0].viento[i].velocidad;
                    b = true;
                }
            }

            var estado = datosOrihuela2[0].prediccion.dia[0].estadoCielo;

            //Para saber la localizacion
            var settingsOrihuela3 = {
                "async": true,
                "crossDomain": true,
                "url": "https://opendata.aemet.es/opendata/api/maestro/municipio/id03099?api_key=" + key,
                "method": "GET",
                "headers": {
                    "cache-control": "no-cache"
                }
            }

            $.ajax(settingsOrihuela3).done(function (response) {
                var datosOrihuela = JSON.parse(response);

                var nomvre = datosOrihuela[0].nombre;

                navigator.geolocation.getCurrentPosition(function (position) {
                    var loc = new Microsoft.Maps.Location(datosOrihuela[0].latitud_dec, datosOrihuela[0].longitud_dec);
                    //Añado marcador en la posición obtenido del usuario.
                    if (estado == "Despejado" || estado == "Despejado noche") {
                        //pongo sol
                        iconito = 'images/solecito.png';
                    } else if (estado == "Nuboso" || estado == "Muy nuboso" || estado == "Nuboso noche" || estado == "Muy nuboso noche") {
                        //pongo nubes
                        iconito = 'images/nublado.png';
                    } else {
                        //pongo lluvia
                        iconito = 'images/nubecita.png';
                    }

                    var pin2 = new Microsoft.Maps.Pushpin(loc, { icon: iconito });
                    map2.entities.push(pin2);

                    //Centro el mapa en la posición obtenida del usuario.
                    map2.setView({ center: loc, zoom: 6 });

                    //Aquí añadimos la caja con información
                    var center = map2.getCenter();

                    Microsoft.Maps.Events.addHandler(pin2, 'click', function () {
                        var infobox = new Microsoft.Maps.Infobox(loc, { title: nomvre, description: "<p>Direccion del viento: </p>" + bientoDir + "<p>Velocidad del viento: </p>" + bientoVel /*+ "<p>Temperatura maxima: </p>" + tempMax + "<p>Temperatura minima: </p>" + tempMin*/ });
                        infobox.setMap(map2);
                    });
                });
            });
        });
    });
};