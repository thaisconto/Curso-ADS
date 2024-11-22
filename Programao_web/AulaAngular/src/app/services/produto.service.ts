import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProdutoService {
  private apiUrl = 'http://localhost:3000/produto'; // URL da API

  constructor(private http: HttpClient) {}

  // Método para obter todos os produtos
  obterProdutos(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
}
