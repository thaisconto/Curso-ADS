import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { FeatureComponent } from './feature/feature.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { CalcularJurosSimplesComponent } from './calcular-juros-simples/calcular-juros-simples.component';
import { ExemploDiretivaComponent } from './exemplo-diretiva/exemplo-diretiva.component';
import { TarefasComponent } from './tarefas/tarefas.component';
import { ClienteComponent } from './cliente/cliente.component';
import { ListaClienteComponent } from './cliente/lista-cliente/lista-cliente.component';
import { ListaCompraClienteComponent } from './cliente/lista-compra-cliente/lista-compra-cliente.component';
import { EditarClienteComponent } from './cliente/editar-cliente/editar-cliente.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component:HomeComponent},
  {path: 'about', component:AboutComponent},
  {path: 'feature', component:FeatureComponent},
  {path: 'calcularJuros', component:CalcularJurosSimplesComponent},
  {path: 'exemploDiretivas', component:ExemploDiretivaComponent},
  {path: 'tarefas', component:TarefasComponent},
  {path: 'cliente', component:ClienteComponent,
    children:[
      {path: 'lista-cliente', component:ListaClienteComponent},
      {path: 'lista-compra', component:ListaCompraClienteComponent},
      {path: 'editar-cliente/:id', component:EditarClienteComponent},
    ],
  },
  {path: '**', component: NotfoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
