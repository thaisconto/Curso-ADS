/*import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  // Variáveis para armazenar os valores de usuário e senha
let usernameValue: string = '';
let passwordValue: string = '';

// Obtém os elementos do DOM
const usernameInput = document.getElementById('username') as HTMLInputElement;
const passwordInput = document.getElementById('password') as HTMLInputElement;
const loginForm = document.getElementById('login-form') as HTMLFormElement;
const errorMessage = document.getElementById('error-message') as HTMLParagraphElement;

// Captura o valor do campo de usuário quando o usuário digita
usernameInput.addEventListener('input', (event: Event) => {
  const target = event.target as HTMLInputElement;
  usernameValue = target.value; // Atualiza o valor da variável
  console.log(Usuário: ${usernameValue}); // Exibe o valor no console (opcional)
});

// Captura o valor do campo de senha quando o usuário digita
passwordInput.addEventListener('input', (event: Event) => {
  const target = event.target as HTMLInputElement;
  passwordValue = target.value; // Atualiza o valor da variável
  console.log(Senha: ${passwordValue}); // Exibe o valor no console (opcional)
});

// Função de validação ao clicar no botão "Entrar"
loginForm.addEventListener('submit', (event: Event) => {
  event.preventDefault(); // Impede o recarregamento da página

  // Validação simples de credenciais
  if (usernameValue === 'admin' && passwordValue === '123') {
    errorMessage.style.display = 'none'; // Esconde a mensagem de erro, caso visível
    alert('Login bem-sucedido! Redirecionando para Home...');
    // Redirecionar ou realizar outras ações necessárias
    window.location.href = "/home";
  } else {
    errorMessage.style.display = 'block';
    errorMessage.textContent = 'Usuário ou senha inválido';
  }
});


}
