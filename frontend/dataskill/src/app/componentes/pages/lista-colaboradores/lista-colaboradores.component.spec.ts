import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaColaboradoresComponent } from './lista-colaboradores.component';

describe('ListaColaboradoresComponent', () => {
  let component: ListaColaboradoresComponent;
  let fixture: ComponentFixture<ListaColaboradoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListaColaboradoresComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListaColaboradoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
