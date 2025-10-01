import { Component, OnInit } from '@angular/core';
import { LoginDTORequest } from '../../../models/LoginDTORequest';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
  logodataskill:string = "assets/dataskill.png"

  LoginData: LoginDTORequest = {
    nome: '',
    senha: ''
  };

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.loginService.login(this.LoginData.nome, this.LoginData.senha).subscribe(
      (response: any) => {
        // Sucesso no login
        console.log('Login bem-sucedido:', response);
        // Redirecionar para a página desejada após o login
        this.router.navigate(['/perfil']);
      },
      (error: any) => {
        // Erro no login
        console.error('Erro no login:', error);
        alert('Nome ou senha incorretos. Tente novamente.');
      }
    );
  }
}
