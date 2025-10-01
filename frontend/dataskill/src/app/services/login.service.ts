import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
   private apiUrl = `${environment.ApiUrl}`;

  constructor(private http: HttpClient) { }

  login(nome: string, senha: string) {
    const body = { nome ,senha };
    return this.http.post(`${this.apiUrl}login`, body);
  }
}
