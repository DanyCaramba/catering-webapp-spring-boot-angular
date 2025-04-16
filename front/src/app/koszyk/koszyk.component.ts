import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { KoszykService, KoszykItem } from '../service/koszyk.service';
import { klient } from '../klasy/klient';
import { KlientService } from '../service/klient.service';
import { Zamowienie } from '../klasy/zamowienie';
import { ZamowienieService } from '../service/zamowienie.service';
import { ZamowienieDietaService } from '../service/zamowienie-dieta.service';
import { ZamowienieDieta } from '../klasy/zamowienie-dieta';
import { PaypalDTO, PaypalService } from '../service/paypal.service';

@Component({
  selector: 'app-koszyk',
  templateUrl: './koszyk.component.html',
  styleUrls: ['./koszyk.component.css']
})
export class KoszykComponent implements OnInit {
    user='';
    user3: klient = new klient('','','','');
    zapisaneid:any ;
    koszykItems: KoszykItem[] = [];
    zamowienie: Zamowienie = new Zamowienie( 1212, 'username');
    zamowieniedieta: ZamowienieDieta = new ZamowienieDieta( 1212, 1,1,1);
    paypaldto: PaypalDTO = new PaypalDTO(1);
  constructor(private keycloakService: KeycloakService,private koszykservice:KoszykService,private klientService: KlientService,
              private zamowienieserwis:ZamowienieService,private zamowieniedietaserwis:ZamowienieDietaService, private paypalservice:PaypalService) { }

  

              ngOnInit() {
                this.keycloakService.isLoggedIn().then(loggedIn => {
                    if (loggedIn) {
                      this.loadUserProfile();
                      this.user = this.keycloakService.getUsername();
                      this.es();
                    }
                    else{

                    }
                    this.koszykItems = this.koszykservice.getItems();
                });
            }


  makePayment() {
    let total = this.getCalkowityKoszt();
    let tempZamowienieDieta = new PaypalDTO(total
    );
    this.paypalservice.makePayment(tempZamowienieDieta).subscribe(
      response => {
        window.location.href = response.url; 

      },
      error => {
        console.error('Wystąpił błąd podczas płatności:', error);
      }
    );
  }

  private loadUserProfile(): void {
    this.keycloakService.loadUserProfile().then(userProfile => {
      this.user3.imie = userProfile.firstName;
      this.user3.nazwisko = userProfile.lastName;
      this.user3.email = userProfile.email;
      this.user3.username = userProfile.username;
    });
  }

  es() {
    this.klientService.saveUser(this.user3).subscribe(response => {
    });
  }
  
  wyczyscKoszyk(): void {
    this.koszykservice.wyczyscKoszyk();
    this.koszykItems = [];
  }

  usunPrzedmiot(idDiety: number): void {
    this.koszykservice.usunZKoszyka(idDiety);
    this.koszykItems = this.koszykservice.getItems();
  }

  getCalkowityKoszt(): number {
    return this.koszykservice.obliczCalkowityKoszt();
  }

  zapiszzamowienie() {
    if (this.koszykItems.length==0)
    {
      alert('Masz pusty koszyk!');
    }
    else {

    const imie = (document.getElementById('imie') as HTMLInputElement).value;
    const nazwisko = (document.getElementById('nazwisko') as HTMLInputElement).value;
    const kodPocztowy = (document.getElementById('kodPocztowy') as HTMLInputElement).value;
    const miejscowosc = (document.getElementById('miejscowosc') as HTMLInputElement).value;
    const ulica = (document.getElementById('ulica') as HTMLInputElement).value;
    const numerBudynku = (document.getElementById('numerBudynku') as HTMLInputElement).value;
    const checkbox = (document.getElementById('myCheckbox') as HTMLInputElement).checked;

    if (!imie || !nazwisko || !kodPocztowy || !miejscowosc || !ulica || !numerBudynku || !checkbox) {
        alert('Proszę wypełnić wszystkie pola formularza i potwierdzić polityke.');
    } else {
      this.zamowienie.cenaZamowienia = this.getCalkowityKoszt();
      this.zamowienie.username = this.user3.username;
      this.zamowienieserwis.saveZamowienie(this.zamowienie).subscribe(
        data => {
          let zapisaneidNumber: number = Number(data);
          this.zapisaneid = zapisaneidNumber;
          this.zapiszprodukty();
        },
        error => {
          console.error('Błąd:', error);
        }
      );
    }
  }
  }

  zapiszprodukty(): void {
    this.koszykItems.forEach(item => {
      let tempZamowienieDieta = new ZamowienieDieta(
        this.zapisaneid,
        item.dieta.idDiety,
        item.iloscDni,
        item.dieta.cena * item.iloscDni
      );
      this.zamowieniedietaserwis.saveZamowienie(tempZamowienieDieta).subscribe(
        (data:any) => {
        //  console.log('Zapisano pomylsnie', data);
        },
        error => {
          console.error('blad zapisu diety', error);
        }
      );
    });

    this.makePayment();
    localStorage.clear();
    this.wyczyscKoszyk();
  }

}
