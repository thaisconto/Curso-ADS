import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProdutoService {
  private apiUrl = 'http://localhost:3000/produto';

  constructor(private http: HttpClient) {}

  obterProdutos(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  adicionarProduto(produto: any): Observable<any> {
    // Aqui passamos o objeto produto no corpo da requisição POST
    return this.http.post<any>(this.apiUrl, produto);
  }
}
