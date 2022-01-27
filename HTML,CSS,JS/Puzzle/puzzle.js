function imagenesIndex(){
    //if (document.body.getAttribute('data-pagina') == 'index'){
        // document.querySelector('#imagenes').innerHTML = "";
    //}
        
    let xhr = new XMLHttpRequest();
    let url = `api/imagenes`;
    let long ;
    xhr.open('GET', url, true);

    xhr.onload = function () {
        let r = JSON.parse(xhr.responseText);
        let arrI = [];
        let imagenes = r.FILAS;
        long = imagenes.length;
        // let html = "";
        // function(e, idx){
        imagenes.forEach(function(imagen, idx) {
            // html += generarHtmlImagen(imagen);
            console.log(imagen.id);
            console.log(imagen);
            arrI.push(imagen);
            console.log(arrI);
            // cargarImagen(imagen, idx);
        });

        // document.querySelector('#imagenes').innerHTML = html;

    };
    
        // cargarImagen(arrI, i);
    
    xhr.send();
    return arrI;
}


function tablaPuntuacion(pag){
    let xhr = new XMLHttpRequest(),
        url = `api/puntuaciones?ord=dd,ja&pag=${pag}&lpag=3`,
        numFilas = 0,
        html = '',
        total_coincidencias, reg_pagina = 3, 
        num_max_pagina; 

    xhr.open('GET', url, true);
    xhr.onload = function () {
        
        let r = JSON.parse(xhr.responseText);
        if(r.RESULTADO=='OK'){
            // sessionStorage['usuario'] = JSON.stringify(r);
            console.log(sessionStorage['usuario']);

            let fila = r.FILAS;
            numFilas = r.FILAS.length;
            total_coincidencias = r.TOTAL_COINCIDENCIAS;
            num_max_pagina = Math.ceil(total_coincidencias/reg_pagina);
            // paginacion(pag, num_max_pagina)
            html +=`<tr>
            <th scope="row">Pos</th>
            <th>Imagen</th>
            <th>Jugador</th>
            <th>Nivel</th>
            <th>Jugadas</th>
            </tr>`;
            fila.forEach(function(e, i){
                
                html +=`<tr>
                        <th>${i+1}</th>
                        <td>${e.nombre}</td>
                        <td>${e.usuario}</td>
                        <td>${e.dificultad}</td>
                        <td>${e.jugadas}</td>
                    </tr>`;
            })
            document.querySelector('#default').innerHTML = html;
            // ordenaTabla();
        }
        
    }

    xhr.send();
}

function paginacion(pag){

    pag = pag || 0 ;
    tablaPuntuacion(pag+1)
    
}


function partida(){
    

    // {"dificultad":"","fichero":""}}

   

    var producto=document.getElementById('4x4').value;
    
    var precio=document.getElementById('precio').value;
    
    sessionStorage.setItem(producto,precio); //ó sessionStorage[producto]=precio
    
    mostrarDatos(producto);
        



    // let valor =`usuario: "{\"RESULTADO\":\"OK\",\"CODIGO\":200,\"TOTAL_COINCIDENCIAS\":7,
    // \"PAGINA\":\"0\",\"REGISTROS_POR_PAGINA\":\"3\",\"FILAS\":
    // [{\"id\":5,\"id_imagen\":4,\"usuario\":\"Lucía\",\"dificultad\":\"6x6\",
    // \"jugadas\":32,\"fecha_hora\":\"2021-04-05 17:13:07\",\"nombre\":\"Imagen 4\",
    // \"fichero\":\"img4.jpg\"},{\"id\":7,\"id_imagen\":2,\"usuario\":\"Pepe\",
    // \"dificultad\":\"6x6\",\"jugadas\":32,
    // \"fecha_hora\":\"2021-04-06 17:18:17\",\"nombre\":\"Imagen 2\",
    // \"fichero\":\"img2.jpg\"},{\"id\":3,\"id_imagen\":3,
    // \"usuario\":\"Luis\",\"dificultad\":\"6x6\",\"jugadas\":36,
    // \"fecha_hora\":\"2021-03-04 12:56:15\",\"nombre\":\"Imagen 3\",
    // \"fichero\":\"img3.jpg\"}]}"
    // `; 

    // if(!sessionStorage['usuario']){ 
    //     sessionStorage.setItem("usuario", `"dificultad":"4x4","fichero":"img3.jpg"`);
    // // }
    // let usu = JSON.parse(sessionStorage['usuario']);

    // console.log(usu.dificultad);

}


// function comoSeLLame(pagina, numero_registros_por_pagina) {

//     pagina = pagina || 0;
//     numero_registros_por_pagina = numero_registros_por_pagina || 3;
//     //api/puntuaciones?ord=dd,ja&pag=${pag}&lpag=3
   
//     let xhr = new XMLHttpRequest();
//     let url = `api/puntuaciones/?ord=dd,ja&pag=${pagina}&lpag=${numero_registros_por_pagina}`;


//     xhr.open('GET', url, true);

//     xhr.onload = function () {
//         let r = JSON.parse(xhr.responseText);
//         total_registros = r.TOTAL_COINCIDENCIAS;
//         reg_por_pagina = Number.parseInt(r.REGISTROS_POR_PAGINA);
//         let num_paginas = Math.ceil(total_registros / reg_por_pagina);


//         reconstruirPaginacion(num_paginas, pagina, reg_por_pagina);
//     };

//     xhr.send();
// }

// function reconstruirPaginacion(num_paginas, pagina, reg_por_pagina) {
//     let anterior 	= document.querySelector("#anterior");
//     // let actual 		= document.querySelector("#actual");
//     let siguiente 	= document.querySelector("#siguiente");

//     // actual.innerHTML  = "Pagina " + (pagina + 1) + " de " + num_paginas;
    


//     // const parametrosURL = extraerParametrosDeURL();

   
//     let eventHandlerAnterior = function(ev) {
//         comoSeLLame(pagina - 1, 3);
//     };

//     let eventHandlerSiguiente = function(ev) {
//         comoSeLLame(pagina + 1, 3);
//     };

//     anterior.replaceWith(anterior.cloneNode(true));
//     anterior = document.querySelector("#anterior");
//     anterior.addEventListener("click", eventHandlerAnterior);

//     siguiente.replaceWith(siguiente.cloneNode(true));
//     siguiente = document.querySelector("#siguiente");
//     siguiente.addEventListener("click", eventHandlerSiguiente);

// }



function ordenaTabla(){
    
    var table, rows, switching, i, x, y, jug1, jug2, shouldSwitch;
    table = document.getElementById("default");
    switching = true;
    /*Make a loop that will continue until
    no switching has been done:*/
    while (switching) {
        //start by saying: no switching is done:
        switching = false;
        rows = table.rows;
        /*Loop through all table rows (except the
        first, which contains table headers):*/
        for (i = 1; i < (rows.length - 1); i++) {
            //start by saying there should be no switching:
            shouldSwitch = false;
            /*Get the two elements you want to compare,
            one from current row and one from the next:*/
            x    = rows[i].getElementsByTagName("TD")[2];
            y    = rows[i + 1].getElementsByTagName("TD")[2];
            jug1 = rows[i].getElementsByTagName("td")[3].textContent; 
            jug2 = rows[i + 1].getElementsByTagName("td")[3].textContent;
            //check if the two rows should switch place:
            if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase() /*&& jug1.localeCompare(jug2)<0*/ ) {
                //if so, mark as a switch and break the loop:
                // if(jug1.localeCompare(jug2)>0){
                console.log(x.innerHTML);
                shouldSwitch = true;
                break;
                // }
            }
            // if(jug1.localeCompare(jug2)>0){
            //     shouldSwitch = true;
            //     break;
            // }
        }
        if (shouldSwitch) {
            /*If a switch has been marked, make the switch
            and mark that a switch has been done:*/
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
        }
    }
    
}


function preseleccion(){

    url= 'api/usuarios/login',
	fd= new FormData(formulario),
	nom = '',
	ultimaConexion = '';
	//para hacer: borrar token si esta logueao un susario

	xhr.open('POST', url, true);

	xhr.onload= function(){
		let r=JSON.parse(xhr.responseText);
		
		if(r.RESULTADO=='OK'){
			sessionStorage['usuario']=JSON.stringify(r);
        }
    }

   
}


function prepararCanvas(){
    document.querySelectorAll('canvas').forEach(function(e){
        e.width  = 480;
        e.height = 360;
    })

}

function cargarImagen(arrIm, i){

    prepararCanvas();
    // let imagenes = [];
    // imagenes = imagenesIndex();
    let html = "";
    let arr = document.getElementsByTagName('canvas');
    // let arr = document.querySelector('#imagenes').children;
    // let cv  = document.querySelector('#cv01'),
    for(let i = 0; i < arr.length; i++){

        let cv  = arr[i],
            ctx = cv.getContext('2d'),
            imagen= new Image(),  //imagen, 
            factor;
        
        //imag.src = `./imagenes/${imagen.fichero} alt=${imagen.nombre}`; //Esto no se si esta bien

        imagen.onload = function(){
            factor = cv.width / imagen.width;
            ctx.drawImage(imagen, 0, 0, cv.width, imagen.height * factor);
        }
        // imagen.src = `./imagenes/img1.jpg`;
        imagen.src = devuelveFichero(i+1);
        
        
        // ${imagen_.fichero}
    }
}

function devuelveFichero (i){
    return `./imagenes/img${i}.jpg`;
}

function seleccionarImg(n){
    let arr_cv = document.getElementsByTagName('canvas');
    let cv     = arr_cv[n-1];
    // let u = JSON.parse(sessionStorage['usuario']);
    let u =sessionStorage['usuario']; 
    // fichero:img5.jpg
    // sessionStorage.setItem("usuario", `fichero:img${n}.jpg`);
    // console.log(sessionStorage.usuario.split(',')[1])
    cv.onclick = function(e){
        console.log(e.path[0]);
        // if(!e.path[0].hasAttribute('style'))
        e.path[0].setAttribute("style", "border: 4px solid red" );
        // console.log('id dento de function-->' + e.target.id)
        sessionStorage['usuario'] = (JSON.stringify( `fichero: img${n}.jpg`));
        let usu   = JSON.parse(sessionStorage['usuario']);	
        
    } 
    // document.getElementById("empezar").innerHTML = sessionStorage.getItem("usuario");

}


function generarHtmlImagen(imagen) {
    let html = "";

    cargarImagen(imagen)

    // html += `<article> 
    //         <a href="index.html?id=${imagen.id}">`;

    // html += `<h3 title="${imagen.nombre}"> ${imagen.nombre} </h3>`;
    // html += `<figure>
    //         <img src=imagenes/${imagen.fichero} alt=${imagen.nombre}>
    //         </figure></a>`;
            // <figcaption>${imagen.nombre}</figcaption>
    
    return html;
}

function tablero(num) {
    let cv = document.querySelector('canvas'),
        ctx = cv.getContext('2d'),
        ancho = 0;

    if (num == 3) {
        cv.width = 330;
        cv.height = 330;
        ancho = 330 / num;
        ctx.rect(0, 0, 330, 330);
    }
    else if(num == 9){
        cv.width = 720;
        cv.height = 720;
        ancho = 720 / num;
        ctx.rect(0, 0, 720, 720);
    }else{
        cv.width = 520;
        cv.height = 520;
        ancho = 520 / num;
        ctx.rect(0, 0, 520, 520);
    }
    ctx.fillStyle = '#fff';
    ctx.fill();

    lineas(num);
}


function eligeDif(){

}


//Funcion tocadita pal Antonio
function lineas(num) {
    let cv = document.querySelector('canvas'),
        ctx = cv.getContext('2d'),
        ancho = cv.width / num;

    ctx.beginPath();
    ctx.lineWidth = 2;
    ctx.strokeStyle = '#000';


    // for (let i = 1; i < num; i++) {
    //     ctx.strokeStyle = '#D5DBDB';

    //     ctx.moveTo(i * ancho, 0);
    //     ctx.lineTo(i * ancho, cv.height);

    //     ctx.moveTo(0, i * ancho);
    //     ctx.lineTo(cv.width, i * ancho);
    // }
    // ctx.stroke();

    // ctx.beginPath();
    // ctx.strokeStyle = '#196F3D';

    //Aqui se pintan las lineas verdes de en medio
    if (num == 4) {
        ctx.moveTo(2 * ancho, 0);
        ctx.lineTo(2 * ancho, cv.height);
        ctx.moveTo(0, 2 * ancho);
        ctx.lineTo(cv.width, 2 * ancho);
    }
    else if (num==6){
        for (let q = 1; q < 6; q++) {
            ctx.moveTo(2 * q * ancho, 0);
            ctx.lineTo(2 * q * ancho, cv.height);
            ctx.moveTo(0, 2 * q * ancho);
            ctx.lineTo(cv.width, 2 * q * ancho);
        }
    }else{
        for (let q = 1; q < 8; q++) {
            ctx.moveTo(2 * q * ancho, 0);
            ctx.lineTo(2 * q * ancho, cv.height);
            ctx.moveTo(0, 2 * q * ancho);
            ctx.lineTo(cv.width, 2 * q * ancho);
        }
    }
    ctx.stroke();
    cv.style.border = '2px solid #196F3D';
}
