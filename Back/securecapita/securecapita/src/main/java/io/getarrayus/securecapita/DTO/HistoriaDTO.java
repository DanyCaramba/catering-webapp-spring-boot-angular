package io.getarrayus.securecapita.DTO;

import io.getarrayus.securecapita.tabele.Dieta;
import io.getarrayus.securecapita.tabele.Zamowienie;
import lombok.Data;

@Data
public class HistoriaDTO {

    Dieta dieta;
    Zamowienie zamowienie;
    String nazwa;
    Float cena1;
    float cena2;
    public HistoriaDTO(Dieta dieta, Zamowienie zamowienie) {
        this.dieta = dieta;
        this.zamowienie = zamowienie;
    }
}
