import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ApoliceComponent } from './apolice/apolice.component';
import { CalculadoraComponent } from './calculadora/calculadora.component';
import { CalcularmediaComponent } from './calcularmedia/calcularmedia.component';
import { ConversortemperaturaComponent } from './conversortemperatura/conversortemperatura.component';
import { ImcComponent } from './imc/imc.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component:HomeComponent},
  {path: 'apolice', component:ApoliceComponent},
  {path: 'calculadora', component:CalculadoraComponent},
  {path: 'calcularmedia', component:CalcularmediaComponent},
  {path: 'conversortemperatura', component:ConversortemperaturaComponent},
  {path: 'imc', component:ImcComponent},
  {path: '**', component: NotfoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
