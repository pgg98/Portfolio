import { Injectable } from '@angular/core';
import { sidebarItem } from '../interfaces/sidebar.interface';
import { UsuarioService } from './usuario.service';

@Injectable({
  providedIn: 'root'
})
export class SidebarService {

  menuAdmin: sidebarItem[] =[
    { titulo: 'Dashboard Admin', icono: 'fa fa-tachometer-alt', sub: false, url: '/admin/dashboard'},
    { titulo: 'Gestión usuarios', icono: 'fa fa-users', sub: false, url: '/admin/usuarios'},

    // { titulo: 'Estadisticas', icono: 'fas fa-chart-line', sub: false, url: '/admin/cursos'},
    // { titulo: 'Estadisticas matrix', icono: 'fas fa-chart-line', sub: false, url: '/admin/stats'},

    { titulo: 'Estadisticas', icono: 'fas fa-chart-line', sub: false, url: '/admin/estadisticas'},
    { titulo: 'Motor gráfico', icono: 'fas fa-cubes', sub: false, url: '/admin/motor-grafico'},
    // { titulo: 'Gestión asignaturas', icono: 'fa fa-sticky-note', sub: false, url: '/admin/asignaturas'},
    // { titulo: 'Gestión grupos', icono: 'fa fa-object-group', sub: false, url: '/admin/grupos'},
  ];
  menuAlumno: sidebarItem[]=[
    { titulo: 'Dashboard Alumno', icono: 'fa fa-tachometer-alt', sub: false, url: '/alu/dashboard'},
  ];
  menuProfesor: sidebarItem[]=[
    { titulo: 'Dashboard Profesor', icono: 'fa fa-tachometer-alt', sub: false, url: '/prof/dashboard'},
    { titulo: 'Asignaturas - Items', icono: 'fa fa-copy', sub: false, url: '/prof/asignaturas'},
  ];
  none: sidebarItem[]=[
    { titulo: 'error', icono: 'fa fa-exclamation-triangle', sub: false, url: '/error'}
  ]
  constructor( private usuarioService: UsuarioService) { }

  getmenu() {

    switch (this.usuarioService.rol) {
      case 'ROL_ADMIN':
        return this.menuAdmin;
      case 'ROL_PROFESOR':
        return this.menuProfesor;
      case 'ROL_ALUMNO':
        return this.menuAlumno;
    }

    return this.none;
  }
}
