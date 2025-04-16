package io.getarrayus.securecapita.tabele;

import jakarta.persistence.*;


@Entity
@Table(name="klient")
public class Klient {
    @Id
    private String username;
    @Column(name= "imie")
    private String imie;
    @Column(name= "nazwisko")
    private String nazwisko;
    @Column(name= "email")
    private String email;

    public Klient ()
    {

    }
    public Klient(String id, String imie, String nazwisko, String email) {
        this.username = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
