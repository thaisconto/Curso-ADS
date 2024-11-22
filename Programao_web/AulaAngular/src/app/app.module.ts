import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomeComponent } from './home/home.component';
import { FeatureComponent } from './feature/feature.component';
import { AboutComponent } from './about/about.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CalcularJurosSimplesComponent } from './calcular-juros-simples/calcular-juros-simples.component';
import { ExemploDiretivaComponent } from './exemplo-diretiva/exemplo-diretiva.component';
import { TarefaComponent } from './tarefa/tarefa.component';
import { ClienteComponent } from './cliente/cliente.component';
import { ListaClienteComponent } from './cliente/lista-cliente/lista-cliente.component';
import { ListaCompraClienteComponent } from './cliente/lista-compra-cliente/lista-compra-cliente.component';
import { EditarClienteComponent } from './cliente/editar-cliente/editar-cliente.component';
import { FormTemplateDriveComponent } from './form-template-drive/form-template-drive.component';
import { FormReactiveComponent } from './form-reactive/form-reactive.component';
import { FormExercicioComponent } from './form-exercicio/form-exercicio.component';
import { ExercicioAc2Component } from './exercicio-ac2/exercicio-ac2.component';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FeatureComponent,
    AboutComponent,
    NotFoundComponent,
    CalcularJurosSimplesComponent,
    ExemploDiretivaComponent,
    TarefaComponent,
    ClienteComponent,
    ListaClienteComponent,
    ListaCompraClienteComponent,
    EditarClienteComponent,
    FormTemplateDriveComponent,
    FormReactiveComponent,
    FormExercicioComponent,
    ExercicioAc2Component,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
