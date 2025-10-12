import { Colaborador } from './../../../models/colaborador/Colaborador';
import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { ColaboradorService } from '../../../services/colaborador/colaborador.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule} from '@angular/forms';

@Component({
  selector: 'app-lista-colaboradores',
  standalone: true,
  imports: [CommonModule, HttpClientModule, FormsModule],
  templateUrl: './lista-colaboradores.component.html',
  styleUrls: ['./lista-colaboradores.component.css']
})
export class ListaColaboradoresComponent {
  btnCadastro:boolean = true ;

  colaborador:Colaborador = new Colaborador();

  //JSON DE COLABORADORES
  colaboradores:Colaborador[] = [];

  constructor(private service:ColaboradorService){}

  selecionar():void{
    this.service.selecionar().subscribe(retorno => this.colaboradores = retorno);
  }

  cadastrar():void{
    this.service.cadastrar(this.colaborador).subscribe(retorno => {
      this.colaboradores.push(retorno);

      //Limpa Colaborador
      this.colaborador = new Colaborador();

      //Mensagem
      alert("Cadastrado com Sucesso!");

      window.location.reload()
    });
  }

  //inicializaçao
  ngOnInit(){
    this.selecionar();
  }
}
