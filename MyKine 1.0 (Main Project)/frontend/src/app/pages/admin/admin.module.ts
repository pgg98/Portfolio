import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { CommonsModule } from '../../commons/commons.module';

import { CursosComponent } from './cursos/cursos.component';
import { CursoComponent } from './curso/curso.component';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { UsuarioComponent } from './usuario/usuario.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AsignaturasComponent } from './asignaturas/asignaturas.component';
import { AsignaturaComponent } from './asignatura/asignatura.component';
import { GruposComponent } from './grupos/grupos.component';
import { GrupoComponent } from './grupo/grupo.component';
import { StatsComponent } from './stats/stats.component';

import { EstadisticasComponent } from './estadisticas/estadisticas.component';
import { MotorGraficoComponent } from './motor-grafico/motor-grafico.component';
import { EngineComponent } from './motor-grafico/engine/engine.component';
import { UiInfobarBottomComponent } from './motor-grafico/ui/ui-infobar-bottom/ui-infobar-bottom.component';
import { UiInfobarTopComponent } from './motor-grafico/ui/ui-infobar-top/ui-infobar-top.component';
import { UiSidebarLeftComponent } from './motor-grafico/ui/ui-sidebar-left/ui-sidebar-left.component';
import { UiSidebarRightComponent } from './motor-grafico/ui/ui-sidebar-right/ui-sidebar-right.component';
import { UiComponent } from './motor-grafico/ui/ui.component';


@NgModule({
  declarations: [
    DashboardComponent,
    CursosComponent,
    CursoComponent,
    UsuariosComponent,
    UsuarioComponent,
    AsignaturasComponent,
    AsignaturaComponent,
    GruposComponent,
    GrupoComponent,
    StatsComponent,
    EstadisticasComponent,
    MotorGraficoComponent,
    EngineComponent,
    UiInfobarBottomComponent,
    UiInfobarTopComponent,
    UiSidebarLeftComponent,
    UiSidebarRightComponent,
    UiComponent
  ],
  exports: [
    CursosComponent,
    CursoComponent,
    UsuariosComponent,
    UsuarioComponent,
    DashboardComponent,
    AsignaturasComponent,
    AsignaturaComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    CommonsModule,
  ]
})
export class AdminModule { }
