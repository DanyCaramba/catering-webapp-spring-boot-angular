package io.getarrayus.securecapita.tabele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name="diety")
public class Dieta {
    @Id
    private long id;
    @Column(name= "Nazwa")
    private String nazwa;
    @Column(name= "Kalorie")
    private int kalorie;
    @Column(name= "Czy_weg")
    private String czy_weg;
    @Column(name= "Cena")
    private float cena;
    @Column(name= "Liczba_posilkow")
    private int liczba_posilkow;
    @Column(name="Opis")
    private String opis;
    @Column(name="zdjmale")
    private String zdjmale;
    @Column(name="krotkiopis")
    private String krotkiopis;



    @OneToMany(mappedBy = "dieta", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ZamowienieDieta> zamowieniaDieta;


    public Dieta(){

    }


    public String getKrotkiopis() {
        return krotkiopis;
    }

    public String getZdjmale() {
        return zdjmale;
    }

    public long getIdDiety() {
        return id;
    }

    public int getKalorie() {
        return kalorie;
    }

    public String getCzy_weg() {
        return czy_weg;
    }

    public float getCena() {
        return cena;
    }

    public int getLiczba_posilkow() {
        return liczba_posilkow;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getOpis() {
        return opis;
    }


}
