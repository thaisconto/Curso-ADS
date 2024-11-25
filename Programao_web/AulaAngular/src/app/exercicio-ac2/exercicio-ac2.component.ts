import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ProdutoService } from '../services/produto.service';

@Component({
  selector: 'app-exercicio-ac2',
  templateUrl: './exercicio-ac2.component.html',
  styleUrls: ['./exercicio-ac2.component.css'],
})
export class ExercicioAc2Component {
  form: FormGroup;
  listaDeCompras: any[] = [];
  mostrarTabela: boolean = false;

  constructor(private produtoService: ProdutoService) {
    this.form = new FormGroup({
      produto: new FormControl('', Validators.required),
      unidade: new FormControl('', Validators.required),
      quantidade: new FormControl('', Validators.required),
    });
  }

  adicionar() {
    if (this.form.valid) {
      this.listaDeCompras.push(this.form.value);
      this.form.reset();
    }
  }

  listar() {
    this.produtoService.obterProdutos().subscribe(
      (produtos) => {
        this.listaDeCompras = produtos;
        this.mostrarTabela = true;
      },
      (erro) => {
        console.error('Erro ao obter produtos:', erro);
      }
    );
  }
}
