import { Dieta } from "./dieta";
import { Zamowienie } from "./zamowienie";

export class ZamowienieDieta {
    zamowienieId: number;       
    dietaId: number;           
    iloscDni: number;          
    cenaLaczna: number ;        
    
    constructor(zamowienie_id: number, dieta_id: number, ilosc_dni: number, cena_laczna: number) {
        this.zamowienieId = zamowienie_id;
        this.dietaId = dieta_id;
        this.iloscDni = ilosc_dni;
        this.cenaLaczna = cena_laczna;
    }

    
    
}
