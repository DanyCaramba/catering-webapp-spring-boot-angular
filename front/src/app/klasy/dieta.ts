export class  Dieta{
    idDiety: number;
    nazwa: string;
    kalorie: number;
    czy_weg: string;
    cena: GLfloat;
    liczba_posilkow: number;
    opis: string;
    zdjmale: String
    krotkiopis:String
  

    constructor(id: number, nazwa: string, Kalorie: number,Czy_weg: string,cena:GLfloat,liczbap:number,opis:string,zdjmale:String, krotkiopis:String) {
        this.idDiety = id;
        this.nazwa = nazwa;
        this.kalorie = Kalorie;
        this.czy_weg = Czy_weg;
        this.cena =cena;
        this.liczba_posilkow = liczbap;
        this.opis= opis;
        this.zdjmale=zdjmale;
        this.krotkiopis=krotkiopis;
    }

 
}
