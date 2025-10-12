import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Colaborador } from '../../models/colaborador/Colaborador';

@Injectable({
  providedIn: 'root'
})

export class ColaboradorService {

  private url:string = "http://localhost:8080/usuario";

  constructor(private http:HttpClient) { }

  //Selecionar
  selecionar():Observable<Colaborador[]>{
    return this.http.get<Colaborador[]>(this.url);
  }

  cadastrar(obj:Colaborador):Observable<Colaborador>{
    return this.http.post<Colaborador>(this.url, obj);
  }


}
