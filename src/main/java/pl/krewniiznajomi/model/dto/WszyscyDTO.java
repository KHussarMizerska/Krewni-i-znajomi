package pl.krewniiznajomi.model.dto;

import java.util.Date;

public class WszyscyDTO {

    private String imie;

    private String nazwisko;

    private String dataUr;

    private Long wiekWdniach;

    public WszyscyDTO() {
    }

    public WszyscyDTO(String imie, String nazwisko, String dataUr) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUr = dataUr;
    }

    public WszyscyDTO(String imie, String nazwisko, String dataUr, Long wiekWdniach) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUr = dataUr;
        this.wiekWdniach = wiekWdniach;
    }

    public WszyscyDTO(String imie, String nazwisko, String dataUr, Integer wiekWdniach) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUr = dataUr;
        this.wiekWdniach = wiekWdniach.longValue();
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

    public String getDataUr() {
        return dataUr;
    }

    public void setDataUr(String dataUr) {
        this.dataUr = dataUr;
    }

    public Long getWiekWdniach() {
        return wiekWdniach;
    }

    public void setWiekWdniach(Long wiekWdniach) {
        this.wiekWdniach = wiekWdniach;
    }

    @Override
    public String toString() {
        return "Wszyscy{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataUr=" + dataUr +
                ", wiekWdniach=" + wiekWdniach +
                '}';
    }
}







