import { Component, OnInit } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { UsuarioService } from '../../../services/usuario.service';
import { Usuario } from '../../../models/usuario.model';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-fisiosdestacados',
  templateUrl: './fisiosdestacados.component.html',
  styleUrls: ['./fisiosdestacados.component.css']
})
export class FisiosdestacadosComponent implements OnInit {

  public loading = true;

  public totalusuarios = 0;
  public posicionactual = 0;
  public registrosporpagina = environment.registros_por_pagina;

  private ultimaBusqueda = '';
  public listaUsuarios: Usuario[] = [];

  public listaUsuariosFiltrada: Usuario[] = [];

  public usu;

  public pruebaUID = '61cc996366d8c96a2c526959';  //Esto es una prueba para ver como seria con un id metido a mano

  constructor( private ususuarioService: UsuarioService) { }

  ngOnInit(): void {
    // this.cargarUsuario(this.pruebaUID);

    this.cargarUsuarios(this.ultimaBusqueda);
  }


  // Recupera los datos del usuario de prueba
  // cargarUsuario( UID ) {
  //   this.ususuarioService.cargarUsuario(UID)
  //     .subscribe( res => {

  //       this.usu = res['usuarios'];
  //       console.log(this.listaUsuarios);

  //       this.loading = false;
  //     }, (err) => {
  //       Swal.fire({icon: 'error', title: 'Oops...', text: 'No se pudo completar la acción, vuelva a intentarlo',});
  //       //console.warn('error:', err);
  //       this.loading = false;
  //     });
  // }

  crearImagenUrl(imagen: string) {
    return this.ususuarioService.crearImagenUrlBest(imagen);
  }

  // Vamos a intentar sacar varios usuarios para meterlos cado uno en una seccion de fisio destacado
  cargarUsuarios( textoBuscar: string ) {
    this.ultimaBusqueda = textoBuscar;
    this.loading = true;
    this.ususuarioService.cargarUsuariosBest( this.posicionactual, textoBuscar )
      .subscribe( res => {
        // Lo que nos llega lo asignamos a lista usuarios para renderizar la tabla
        // Comprobamos si estamos en un apágina vacia, si es así entonces retrocedemos una página si se puede
        if (res['usuarios'].length === 0) {
          if (this.posicionactual > 0) {
            this.posicionactual = this.posicionactual - this.registrosporpagina;
            if (this.posicionactual < 0) { this.posicionactual = 0};
            this.cargarUsuarios(this.ultimaBusqueda);
          } else {


            this.listaUsuarios = [];
            this.totalusuarios = 0;
          }
        } else {

          this.listaUsuarios = res['usuarios'];

          var i:number;

          for(i = 0;i<this.listaUsuarios.length;i++) {
            if(this.listaUsuarios[i].rol == "ROL_FISIO"){
              this.listaUsuariosFiltrada.push(this.listaUsuarios[i]);
            }
          }

          console.log(this.listaUsuarios);
          console.log(this.listaUsuariosFiltrada);
          this.totalusuarios = res['page'].total;
        }
        this.loading = false;
      }, (err) => {
        Swal.fire({icon: 'error', title: 'Oops...', text: 'No se pudo completar la acción, vuelva a intentarlo',});
        //console.warn('error:', err);
        this.loading = false;
      });
  }
}
