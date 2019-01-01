package pl.krewniiznajomi.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "wszyscy")
@Immutable
public class Wszyscy {

    @Id // dodajemy sztuczne @Id nawet jeśli to nie jest primary key w widoku (bo tam nie ma PK i tak)
    @Column(name = "imie")
    private String imie;
    @Column(name = "nazwisko")
    private String nazwisko;
    @Column(name = "data_ur")
    private Date dataUr;

    public Wszyscy() {
    }

    public Wszyscy(String imie, String nazwisko, Date dataUr) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUr = dataUr;
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

    public Date getDataUr() {
        return dataUr;
    }

    public void setDataUr(Date dataUr) {
        this.dataUr = dataUr;
    }

    @Override
    public String toString() {
        return "Wszyscy{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataUr=" + dataUr +
                '}';
    }
}







