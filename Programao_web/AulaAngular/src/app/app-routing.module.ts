import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { FeatureComponent } from './feature/feature.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { CalcularJurosSimplesComponent } from './calcular-juros-simples/calcular-juros-simples.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component:HomeComponent},
  {path: 'about', component:AboutComponent},
  {path: 'feature', component:FeatureComponent},
  {path: 'calcularJuros', component:CalcularJurosSimplesComponent},
  {path: '**', component: NotfoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
