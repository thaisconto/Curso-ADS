import { Component } from '@angular/core';

@Component({
  selector: 'app-conversortemperatura',
  templateUrl: './conversortemperatura.component.html',
  styleUrl: './conversortemperatura.component.css'
})
export class ConversortemperaturaComponent {
  celsius: number = 0;
  fahrenheit: number | null = null;
  kelvin: number | null = null;

  converterTemperatura(): void {
    this.fahrenheit = (this.celsius * 9/5) + 32;
    this.kelvin = this.celsius + 273.15;
  }
}
