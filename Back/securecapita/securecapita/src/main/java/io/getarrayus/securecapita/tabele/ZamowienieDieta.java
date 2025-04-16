package io.getarrayus.securecapita.tabele;

import jakarta.persistence.*;

@Entity
@Table(name = "zamowienie_dieta")
public class ZamowienieDieta {

    @Id
    @Column(name = "dieta_zamowienie_id")
    private long dietaZamowienieId;


    @Column(name = "ilosc_dni")
    private int iloscDni;

    @Column(name = "cena_laczna")
    private float cenaLaczna;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name ="zamowienie_id" )
    private Zamowienie zamowienie;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name ="dieta_id" )
    private Dieta dieta;

    public ZamowienieDieta() {
    }

    public ZamowienieDieta(int iloscDni, float cenaLaczna, Zamowienie zamowienie, Dieta dieta) {
        this.iloscDni = iloscDni;
        this.cenaLaczna = cenaLaczna;
        this.zamowienie = zamowienie;
        this.dieta = dieta;
    }

    public Zamowienie getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }


    public long getDietaZamowienieId() {
        return dietaZamowienieId;
    }

    public void setDietaZamowienieId(int dietaZamowienieId) {
        this.dietaZamowienieId = dietaZamowienieId;
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
