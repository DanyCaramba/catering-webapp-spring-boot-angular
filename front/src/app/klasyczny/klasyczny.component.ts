import { Component, OnInit } from '@angular/core';
import { Dieta } from '../klasy/dieta';
import { DietaService } from '../service/dieta.service';
import {MatNativeDateModule} from '@angular/material/core';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatFormFieldModule} from '@angular/material/form-field';
import { KoszykService } from '../service/koszyk.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-klasyczny',
  templateUrl: './klasyczny.component.html',
  styleUrls: ['./klasyczny.component.css']
})
export class KlasycznyComponent implements OnInit{


  startDate: Date | null = null;
  endDate: Date | null = null;
  x: Number | undefined;
  dietaDoWyswietlenia: Dieta | undefined;
  diety: Dieta[] = [];


  constructor(private dietService:DietaService,private koszykservice:KoszykService,private router: Router ){}
  
  ngOnInit(): void {
    this.getdiety();
  }

 getx(): number | null {
    const value = localStorage.getItem('myNumber');
    return value !== null ? parseInt(value, 10) : null;
  }


  obliczIloscDni(): number {
    if (!this.startDate || !this.endDate) {
      return 0;
    }
    const diff = this.endDate.getTime() - this.startDate.getTime();
    return Math.ceil(diff / (1000 * 3600 * 24));
  }

  zamowDieta(): void {
    if (this.dietaDoWyswietlenia) {
      const dzisiaj = new Date();
      dzisiaj.setHours(0, 0, 0, 0);
      const iloscDni = this.obliczIloscDni();
      if (iloscDni === 0) {
        alert('Proszę wybrac odpowiedni zakres zakres dat');
        return;
      }

      if (this.startDate!.getTime() < dzisiaj.getTime()) {
        alert("Data rozpoczęcia nie może być wcześniejsza niż dzisiejsza data.");
        return;
      }
      
      this.koszykservice.dodajDoKoszyka(this.dietaDoWyswietlenia,iloscDni,this.dietaDoWyswietlenia.zdjmale);
      this.router.navigate(['/Koszyk']);
    } else {
    
    }
  }
  private wybierz()
  {
    this.dietaDoWyswietlenia=this.diety.find(dieta => dieta.idDiety ===this.getx());
    
  }
  private getdiety()
  {
    this.dietService.getDietaList().subscribe(data=>{
      this.diety=data;
      this.wybierz();
    });
  }

}
