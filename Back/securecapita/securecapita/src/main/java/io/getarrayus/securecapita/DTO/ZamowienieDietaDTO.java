package io.getarrayus.securecapita.DTO;

import io.getarrayus.securecapita.tabele.ZamowienieDieta;
import lombok.Data;

@Data
public class ZamowienieDietaDTO {
    private int iloscDni;
    private float cenaLaczna;
    private String nazwaDiety;
    private float cena;
    private String zdjmale;

    public ZamowienieDietaDTO(ZamowienieDieta source) {
        this.iloscDni = source.getIloscDni();
        this.cenaLaczna = source.getCenaLaczna();
        if (source.getDieta() != null) {
            this.nazwaDiety = source.getDieta().getNazwa();
        }
        if (source.getDieta() != null) {
            this.cena = source.getDieta().getCena();
        }
        this.zdjmale=source.getDieta().getZdjmale();
    }


    public int getIloscDni() {
        return iloscDni;
    }

    public void setIloscDni(int iloscDni) {
        this.iloscDni = iloscDni;
    }

    public float getCenaLaczna() {
        return cenaLaczna;
    }

    public void setCenaLaczna(float cenaLaczna) {
        this.cenaLaczna = cenaLaczna;
    }


}
