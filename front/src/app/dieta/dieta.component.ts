import { Component, OnInit } from '@angular/core';
import { DietaService } from '../service/dieta.service';
import { Dieta } from '../klasy/dieta';

@Component({
  selector: 'app-dieta',
  templateUrl: './dieta.component.html',
  styleUrls: ['./dieta.component.css']
})
export class DietaComponent implements OnInit{
 
  diety: Dieta[] = [];

  
  constructor(private dietService:DietaService ){}
  
  ngOnInit(): void {
    this.wyswietldiety();
  }


  private wyswietldiety()
  {
    this.dietService.getDietaList().subscribe(data=>{
      this.diety=data;
    });

  }

   przypisz(x: number): void {
    localStorage.setItem('myNumber', x.toString());
  }

  
} 
