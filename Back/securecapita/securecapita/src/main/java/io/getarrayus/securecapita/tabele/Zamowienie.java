package io.getarrayus.securecapita.tabele;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Zamowienia")
public class Zamowienie {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long zamowienie_id;
    @Column(name= "username")
    private String username;
    @Column(name= "cena_zamowienia")
    private float cenaZamowienia;
    @Column(name="data_zamowienia",nullable = false, updatable = false)
    private Date data;
    @OneToMany(mappedBy = "zamowienie", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ZamowienieDieta> zamowieniaDieta;


    public Set<ZamowienieDieta> getZamowieniaDieta() {
        return zamowieniaDieta;
    }

    public Zamowienie() {

    }

    public Date getData() {
        return data;
    }

    public long getZamowienie_id() {
        return zamowienie_id;
    }

    public void setZamowienie_id(long zamowienie_id) {
        this.zamowienie_id = zamowienie_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getCenaZamowienia() {
        return cenaZamowienia;
    }

    public void setCenaZamowienia(float cenaZamowienia) {
        this.cenaZamowienia = cenaZamowienia;
    }
}
