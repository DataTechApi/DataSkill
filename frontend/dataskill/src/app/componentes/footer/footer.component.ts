import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [],
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.css'
})

export class FooterComponent {

  logo_fatec:string = "assets/logo_fatec.png";
  logo_altave:string = "assets/data_tech.png";
}
