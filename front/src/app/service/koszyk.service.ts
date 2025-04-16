import { Injectable } from '@angular/core';
import { Dieta } from '../klasy/dieta';


export interface KoszykItem {
  dieta: Dieta;
  iloscDni: number;
  zdjmale:String;
  razem:number;
}
interface Zamowienie2 {
  zamowienie_id: number;
  username: string;
  cenaZamowienia: number;
}

interface Dieta2 {
  nazwa: string;
  kalorie: number;
  czy_weg: string;
  cena: number;
  liczba_posilkow: number;
  opis: string;
  zdjmale: string;
  krotkiopis: string;
  idDiety: number;
}

export interface ZamowienieDieta2 {
  dietaZamowienieId: number;
  iloscDni: number;
  cenaLaczna: number;
  zamowienie: Zamowienie2;
  dieta: Dieta2;
}

 

@Injectable({
  providedIn: 'root'
})
export class KoszykService {

  private items: KoszykItem[] = [];
  private calosc:number | undefined;
  constructor() { 
    this.loadCart();
  }

  private loadCart() {
    const storedCart = localStorage.getItem('userCart');
    if (storedCart) {
      this.items = JSON.parse(storedCart);
    }
  }

  usunZKoszyka(idDiety: number): void {
    const index = this.items.findIndex(item => item.dieta.idDiety === idDiety);
    if (index !== -1) {
      this.items.splice(index, 1);
      this.saveCart();
    }
  }

  private saveCart() {
    localStorage.setItem('userCart', JSON.stringify(this.items));
  } 
  
  multiplyNumbers(num1: number, num2: number): number {
    return num1 * num2;
    }

  dodajDoKoszyka(dieta: Dieta, iloscDni: number,zdjmale:String): void {
    const item = this.items.find(item => item.dieta.idDiety === dieta.idDiety);
    if (item) {
      const razem = parseFloat((this.multiplyNumbers(iloscDni, dieta.cena)).toFixed(2));
      item.razem = parseFloat((this.multiplyNumbers(item.iloscDni, dieta.cena)).toFixed(2));
      this.items.push({ dieta, iloscDni,zdjmale,razem});
    } else {
      const razem = parseFloat((this.multiplyNumbers(iloscDni, dieta.cena)).toFixed(2));
      this.items.push({ dieta, iloscDni,zdjmale,razem});
    }

    this.saveCart();
  }

  obliczCalkowityKoszt(): number {
    let total = 0;
    this.items.forEach(item => {
      total += item.razem;
    });
    return total;
  }


  getItems(): KoszykItem[] {
    return this.items;
  }

  wyczyscKoszyk(): void {
    this.items = [];
    this.saveCart();
  }

}
