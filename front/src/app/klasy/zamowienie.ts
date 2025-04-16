export class Zamowienie {

    public cenaZamowienia?: Number;

    constructor( cenaZamowienia: Number, public username: string | undefined) {
    
        this.cenaZamowienia = cenaZamowienia;
       
    }
}
