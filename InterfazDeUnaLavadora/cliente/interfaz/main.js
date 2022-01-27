var electro = new Electro();

// Llena un deposito hasta un nivel usando un sensor de nivel y una valvula que abre el flujo
function llenar(sensor, valvula, nivel, callback) {
    console.log("  - Llenar depósito.", sensor, "->", nivel);
    electro.on(sensor, function comprobarNivel(nivelActual) { // monitorizar el sensor
        if (nivelActual >= nivel) { // se ha alzanzado el nivel
            electro.off(sensor, comprobarNivel); // dejar de monitorizar
            console.log("    - Cerrar válvula:", valvula);
            electro[valvula] = false; // cerrar la válvula
            callback();
        }
    });
    console.log("    - Abrir válvula:", valvula);
    electro[valvula] = true; // abro la topa
}

// Vaciar un deposito hasta un nivel usando un sensor de nivel y una válvula que abre el flujo
function vaciar(sensor, valvula, nivel, callback) {
    console.log("  - Vaciar depósito.", sensor, "->", nivel);
    electro.on(sensor, function comprobarNivel(nivelActual) { // monitorizar el sensor
        if (nivelActual <= nivel) { // se ha alzanzado el nivel
            electro.off(sensor, comprobarNivel); // dejar de monitorizar
            console.log("    - Cerrar válvula:", valvula);
            electro[valvula] = false; // cerrar la válvula
            callback();
        }
    });
    console.log("    - Abrir válvula:", valvula);
    electro[valvula] = true; // abro la topa
}

// Establece una temperatura a un valor, encendiendo y apagando una resistencia durante un tiempo (ms)
function termostato(sensor, resistencia, temp, duracion, callback) {
    function comprobarTemp(tempAct) {
        if (tempAct < temp) electro[resistencia] = true;
        if (tempAct > temp) electro[resistencia] = false;
    }
    electro.on(sensor, comprobarTemp);
    comprobarTemp(electro[sensor]); // llamar la primera vez por si tiene que encender
    setTimeout(function () {
        electro[resistencia] = false;
        electro.off(sensor, comprobarTemp);
        callback();
    }, duracion);
}

// Realiza un lavado
function lavar(callback) {
    // Obtener parámetros del lavado
    var
        detergente = document.getElementById("detergente").value,
        suavizante = document.getElementById("suavizante").value,
        nivelAgua = document.getElementById("nivelAgua").value,
        temperaturaLavado = document.getElementById("temperaturaLavado").value,
        revolucionesLavado = document.getElementById("revolucionesLavado").value,
        tiempoLavado = document.getElementById("tiempoLavado").value * 1000,
        revolucionesCentrifugado = document.getElementById("revolucionesCentrifugado").value,
        tiempoCentrifugado = document.getElementById("tiempoCentrifugado").value * 1000;

    // Puerta abierta
    if (electro.puertaAbierta) {
        alert("Puerta abierta!!!!");
        callback();
        return;
    }

    // Hay ropa?
    if (!electro.peso) {
        alert("Parece que no hay ropa en la lavadora.");
        callback();
        return;
    }

    if(detergente > electro.nivelDetergente){
        alert('Tienes menos detergente del que el lavado necesita!');
        callback();
        return;
    }
    if(suavizante > electro.nivelSuavizante){
        alert('Tienes menos suavizante del que el lavado necesita!');
        callback();
        return;
    }

    if(electro.filtroObstruido){
        alert('El filtro esta obstruido!');
        callback();
        return;
    }

    if(suavizante < 1 ){
        alert('Debes de poner suavizante!');
        callback();
        return;
    }

    irLavado(); //Vamos a lavado si todo ha ido bien
    lavadoAmedias();
    console.log("Iniciar lavado");
    electro.puertaBloqueada = true; // Bloquear puerta durante el lavado
    console.log("Puerta bloqueada");
    // Llenar de agua el tambor (para lavado)
    console.log("Llenar de agua (para lavado)...")
    llenar("nivelAgua", "tomaAgua", nivelAgua, function () {
        // Detergente
        console.log("Poner detergente...");
        vaciar("nivelDetergente", "tomaDetergente", electro.nivelDetergente - detergente, function () {
            // Lavado
            console.log("Lavar...")
            electro.tamborRevoluciones = revolucionesLavado;

            /* Intento de cuenta atras en Lavado con el tiempo de lavado
            console.log(`Tiempo de lavado ${tiempoLavado}`);
            updateClock(tiempoLavado);
            console.log(`Tiempo de lavado ${tiempoLavado}`);
            */

            termostato("temperaturaAgua", "resistenciaAgua", temperaturaLavado, tiempoLavado, function () {
                // Vaciar agua
                console.log("Vaciar tambor de agua...");
                vaciar("nivelAgua", "desague", 0, function () {
                    // Llenar de agua para suavizante
                    console.log("Llenar de agua (para suavizante)...")
                    llenar("nivelAgua", "tomaAgua", nivelAgua, function () {
                        // Suavizante
                        console.log("Poner suavizante");
                        vaciar("nivelSuavizante", "tomaSuavizante", electro.nivelSuavizante - suavizante, function () {
                            // Vaciar agua
                            console.log("Vaciar tambor de agua...");
                            vaciar("nivelAgua", "desague", 0, function () {
                                // Centrifugar
                                console.log("Centrifugar...")
                                electro.tamborRevoluciones = revolucionesCentrifugado;
                                setTimeout(function () { 
                                    lavadoTerminado();
                                    console.log("Fin del lavado!!!");
                                    electro.tamborRevoluciones = 0; // parar motor
                                    electro.puertaBloqueada = false; // desbloquear puerta
                                    callback();
                                }, tiempoCentrifugado);
                            });
                        });
                    });
                });
            });
        });
    });
}

function presets (nomP, d, s, nA, temL, rL, tiL, rC, tC){
    console.log(nomP);
    detergente.value = d;
    suavizante.value = s;
    nivelAgua.value = nA;
    temperaturaLavado.value = temL;
    revolucionesLavado.value = rL;
    tiempoLavado.value = tiL;
    revolucionesCentrifugado.value = rC;
    tiempoCentrifugado.value = tC;
    irResumen();
    mostrarMensaje(nomP);
}


function programa(pr){
    let ultimo ;
    // let presets = document.getElementById("presets");
    // let detergente = document.getElementById("detergente");
    switch(pr){
        case "algodon":
            // presets (nomP, d, s, nA, temL, rL, tiL, rC, tC)
            presets("algodon", 5, 7, 1, 90, 200, 2, 1000, 1);
            ultimo = 'algodon';
    break;
        case "seda":
            presets("seda", 5, 5, 8, 90, 250, 6, 1200, 4);
            ultimo = 'seda';
    break;
        case "rapido":
            presets("rapido", 5, 5, 10, 90, 200, 1, 1000, 1);
            ultimo = 'rapido';
    break;
        case "lana":
            presets("lana", 5, 42, 80, 90, 200, 2, 1000, 1);
            ultimo = 'lana'
    break;
        case "prelavado":
            presets("prelavado", 5, 5, 80, 35, 200, 2, 1000, 3);
            ultimo = "prelavado"
    break;
        case "sintetica":
            presets("sintetica", 5, 5, 80, 90, 300, 4, 800, 1);
            ultimo = "sintetica"
    break;
        case "color":
            presets("color", 4, 7, 80, 40, 200, 1, 1080, 1);
            ultimo =  "color"
    break;
        case "oscura":
            presets("oscura", 5, 5, 77, 84, 200, 5, 1050, 1);
            ultimo = "oscura"
    break;
        case "camisas":
            presets("camisas", 5, 9, 65, 90, 200, 5, 1000, 3);
            ultimo = "camisas"
    break;
        case "antialergias":
            presets("antialergias", 5, 5, 80, 90, 200, 20, 1000, 10);
            ultimo = "antialergias"
    break;
        default:
            presets("algodon", 5, 5, 80, 90, 200, 20, 1000, 10);
    break;
    }
    ultimoP(ultimo)
    // presets
}   

function ultimoP(u){
    let txt = '';
    butUlt = document.querySelector('#ultlimo');
    txt += `<h3>Reciente</h3>`; 
    txt += `<button class="button" onclick="programa('${u}');">${u}</button>`; 
    butUlt.innerHTML = txt;
}       

function mostrarMensaje(string) {
    let div = document.createElement('div'),
        html;

    div.id = 'mensj_modal';
    html = `<article>
				<h2>Programa: ${string}</h2>
                <h4>Se han cambiado las preferencias del lavado.</h4>
				<button onclick="document.querySelector('#mensj_modal').remove();"> Cerrar</button>
			</article>`
    div.innerHTML = html;
    document.body.appendChild(div);
}


function apagar(){
    electro.puertaBloqueada = false;
    electro.tomaAgua = false;
    electro.tomaDetergente = false;
    electro.tomaSuavizante = false;
    electro.desague = false;
    electro.tamborRevoluciones = 0;
    electro.resistenciaAgua = false;
    electro.resistenciaAire = false;
    electro.flujoAire = false;

    window.location.href = "./apagado.html";
}

function encender(){
    window.location.href = "./index.html";
}

function updateClock(totalTime) {
    document.getElementById('countdown').innerHTML = totalTime;
    if (totalTime == 0) {
        alert('Final');
    } else {
        totalTime -= 1;
        setTimeout("updateClock()", 1000);
    }
}

//Esta no funciona porque no reconoce classList
// var seccionActual = "login";
// function cambiarSeccion(seccion){
//     document.getElementById(seccionActual).classList.remove("activa");
//     document.getElementById(seccion).classList.add("activa");
//     seccionActual = seccion;
// }

function lavadoAmedias() {
    document.getElementById("sinLavado").classList.remove("activa");
    document.getElementById("enCurso").classList.add("activa");
    document.getElementById("terminado").classList.remove("activa");
}

function lavadoTerminado(){
    document.getElementById("sinLavado").classList.remove("activa");
    document.getElementById("enCurso").classList.remove("activa");
    document.getElementById("terminado").classList.add("activa");
}

function irResumen() {
    document.getElementById("programas").classList.remove("activa");
    document.getElementById("lavado").classList.remove("activa");
    document.getElementById("resumen").classList.add("activa");
}

function irProgramas() {
    document.getElementById("resumen").classList.remove("activa");
    document.getElementById("lavado").classList.remove("activa");
    document.getElementById("programas").classList.add("activa");
}

function irLavado() {
    document.getElementById("resumen").classList.remove("activa");
    document.getElementById("programas").classList.remove("activa");
    document.getElementById("lavado").classList.add("activa");
}

electro.on("connect", function () { // Esparar a que la librería se conecte con la lavadora
    console.log("Ya estoy conectado con la lavadora!!")
    console.log("Con este hay " + electro.clientes + " clientes conectados");


    if (document.getElementById("resumen")){
        // Bloqueo de puerta
        var bloqueo = document.getElementById("bloqueo");
        bloqueo.addEventListener("click", function () {
            electro.puertaBloqueada = !electro.puertaBloqueada;
        });
        electro.on("puertaBloqueada", function (bloqueado) {
            bloqueo.innerHTML = bloqueado ? "Desbloquear Puerta" : "Bloquear Puerta";
        });
        // Lavar
        var botonLavar = document.getElementById("lavar");
        botonLavar.addEventListener("click", function () {
        botonLavar.disabled = true;
        lavar(function () {
            botonLavar.disabled = false;
        });
    });

    }


    if (document.body.getAttribute('data-pagina') == 'index'){
        electro.on("nivelDetergente", function (nivelNuevo) {
            // let det  = 'Detergente: ';
            document.getElementById("detergenteQueda").innerHTML = `Detergente: ${nivelNuevo}`;

        })
        electro.on("nivelSuavizante", function (nivelNuevo) {
            // let suav = 'Suavizante: ';
            document.getElementById("suavQueda").innerHTML = `Suavizante: ${nivelNuevo}`;
        })
    }


    // var deter = electro.nivelDetergente;
    // deter.addEventListener("change", function () {
    electro.on("nivelDetergente",function comprobarDetergente(det) {
        if (electro.nivelDetergente>=60) { 
            electro.off("nivelDetergente", comprobarDetergente);
            console.log("    - quita detergente pinche:khdkb");
        }
    } )

    // electro.on("presencia", function detectarPersona(){
    //     if (electro.presencia == false){
    //         apagar();
    //     }else{
    //         encender();
    //     }
    // })

    //Tanto con la de arriba como con la de abajo se quede en bucle recargando la pagina todo el rato

    // if (electro.presencia == false) {
    //     apagar();
    // }else{
    //     encender();
    // }


        // if(electro.nivelDetergente>=60){
        //     botonLavar.disabled=true;
        //     alert('nivel 60')
        // }
    
    // });


});
