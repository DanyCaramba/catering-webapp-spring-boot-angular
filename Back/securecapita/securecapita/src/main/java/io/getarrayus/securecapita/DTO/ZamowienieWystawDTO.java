package io.getarrayus.securecapita.DTO;



import io.getarrayus.securecapita.tabele.Dieta;
import io.getarrayus.securecapita.tabele.Zamowienie;
import io.getarrayus.securecapita.tabele.ZamowienieDieta;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ZamowienieWystawDTO {


    private long zamowienieId;
    private String nazwa;
    private float cenaLaczna;

    private String data;

    private String data2;

    private String zdjmale;
    List<ZamowienieDietaDTO> zamowienieDietasDTO;

    public static String formatAsDdMmYyyy(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(date);
    }


    public ZamowienieWystawDTO(Zamowienie source) {
        this.zamowienieId = source.getZamowienie_id();
        this.cenaLaczna = source.getCenaZamowienia();
        this.zamowienieDietasDTO = source.getZamowieniaDieta().stream()
                .map(ZamowienieDietaDTO::new)
                .collect(Collectors.toList());
        this.nazwa=source.getUsername();
        this.data= formatAsDdMmYyyy(source.getData());



    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<ZamowienieDietaDTO> getZamowienieDietasDTO() {
        return zamowienieDietasDTO;
    }

    public long getZamowienieId() {
        return zamowienieId;
    }

    public void setZamowienieId(long zamowienieId) {
        this.zamowienieId = zamowienieId;
    }


    public String getData() {
        return data;
    }

    public float getCenaLaczna() {
        return cenaLaczna;
    }

    public void setCenaLaczna(float cenaLaczna) {
        this.cenaLaczna = cenaLaczna;
    }



}


