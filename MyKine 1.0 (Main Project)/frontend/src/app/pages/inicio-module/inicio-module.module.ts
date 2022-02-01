import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FisiosdestacadosComponent } from './fisiosdestacados/fisiosdestacados.component';
import { InicioComponent } from './inicio/inicio.component';
import { OlMapsModule } from '../../ol-maps/ol-maps.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    FisiosdestacadosComponent,
    InicioComponent,
  ],
  imports: [
    CommonModule,
    OlMapsModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule
  ]
})
export class InicioModuleModule { }
