import { Component } from '@angular/core';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrl: './produto.component.css'
})
export class ProdutoComponent {
  public semEstoque : boolean = false;

   listProdutos : any[] = [
    {nome:'Produto 1', preco:'R$ 18.99', descricao: 'Produto ok', emEstoque:true},
    {nome:'Produto 2', preco:'R$ 8.99', descricao: 'Produto de qualidade duvidusa', emEstoque:false},
    {nome:'Produto 3', preco:'R$ 299.99', descricao: 'Produto incrível', emEstoque:true},
    ];

    verificarEstoque(): boolean {
      this.semEstoque = this.listProdutos.every(produto => produto.emEstoque === false);
      return this.semEstoque;
    }

}
