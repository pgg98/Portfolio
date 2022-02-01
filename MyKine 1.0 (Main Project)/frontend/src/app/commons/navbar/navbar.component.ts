import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { UsuarioService } from '../../services/usuario.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  imagenUrl: string = '';

  constructor( private usuarioService: UsuarioService) { }

  ngOnInit(): void {
    this.usuarioService.cargarUsuario( this.usuarioService.uid )
      .subscribe( res => {
        this.imagenUrl = `${environment.base_url}/upload/fotoperfil/`+res['usuarios'].imagen || 'no-imagen';
        this.imagenUrl+= `?token=${this.usuarioService.token}`;
      });
  }

  logout() {
    this.usuarioService.logout();
  }
}
