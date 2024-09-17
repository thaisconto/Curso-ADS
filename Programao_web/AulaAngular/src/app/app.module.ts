import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomeComponent } from './home/home.component';
import { FeatureComponent } from './feature/feature.component';
import { AboutComponent } from './about/about.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { FormsModule } from '@angular/forms';
import { CalcularJurosSimplesComponent } from './calcular-juros-simples/calcular-juros-simples.component';
import { ExemploDiretivaComponent } from './exemplo-diretiva/exemplo-diretiva.component';
import { TarefasComponent } from './tarefas/tarefas.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FeatureComponent,
    AboutComponent,
    NotfoundComponent,
    CalcularJurosSimplesComponent,
    ExemploDiretivaComponent,
    TarefasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
