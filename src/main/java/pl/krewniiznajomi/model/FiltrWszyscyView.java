package pl.krewniiznajomi.model;

import java.util.Date;

public class FiltrWszyscyView {

    private String imie;
    private String nazwisko;
    private String dataUr;

    public FiltrWszyscyView(String imie, String nazwisko, String dataUr) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUr = dataUr;
    }

    public FiltrWszyscyView(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public FiltrWszyscyView() {
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
}
