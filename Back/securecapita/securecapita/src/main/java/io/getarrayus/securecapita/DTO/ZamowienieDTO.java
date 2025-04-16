package io.getarrayus.securecapita.DTO;



public class ZamowienieDTO {
    private long zamowienieId;
    private Long dietaId;
    private float cenaLaczna;
    private Integer iloscDni;

    public ZamowienieDTO(int zamowienieId, Long dietaId, float cenaLaczna, Integer iloscDni) {
        this.zamowienieId = zamowienieId;
        this.dietaId = dietaId;
        this.cenaLaczna = cenaLaczna;
        this.iloscDni = iloscDni;

    }

    public long getZamowienieId() {
        return zamowienieId;
    }

    public void setZamowienieId(long zamowienieId) {
        this.zamowienieId = zamowienieId;
    }

    public Long getDietaId() {
        return dietaId;
    }

    public void setDietaId(Long dietaId) {
        this.dietaId = dietaId;
    }

    public float getCenaLaczna() {
        return cenaLaczna;
    }

    public void setCenaLaczna(float cenaLaczna) {
        this.cenaLaczna = cenaLaczna;
    }

    public Integer getIloscDni() {
        return iloscDni;
    }

    public void setIloscDni(Integer iloscDni) {
        this.iloscDni = iloscDni;
    }

}

