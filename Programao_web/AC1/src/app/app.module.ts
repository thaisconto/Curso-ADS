import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CalcularmediaComponent } from './calcularmedia/calcularmedia.component';
import { CalculadoraComponent } from './calculadora/calculadora.component';
import { ApoliceComponent } from './apolice/apolice.component';
import { ConversortemperaturaComponent } from './conversortemperatura/conversortemperatura.component';
import { ImcComponent } from './imc/imc.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    CalcularmediaComponent,
    CalculadoraComponent,
    ApoliceComponent,
    ConversortemperaturaComponent,
    ImcComponent,
    NotfoundComponent,
    HomeComponent
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
