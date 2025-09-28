import { Routes, RouterModule } from '@angular/router';
import { IndexComponent } from './componentes/pages/index/index.component';
import { NgModule } from '@angular/core';
import { LoginComponent } from './componentes/pages/login/login.component';
import { CadastroComponent } from './componentes/pages/cadastro/cadastro.component';
import { PerfilComponent } from './componentes/pages/perfil/perfil.component';
import { HardSkillComponent } from './componentes/pages/hard-skill/hard-skill.component';
import { SoftSkillComponent } from './componentes/pages/soft-skill/soft-skill.component';

export const routes: Routes = [
  { path: '', component:IndexComponent},
  { path: 'login', component:LoginComponent},
  { path: 'cadastro', component:CadastroComponent},
  { path: 'perfil', component:PerfilComponent},
  {path: 'hard-skill', component:HardSkillComponent},
  {path: 'soft-skill', component:SoftSkillComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule{}


