package pl.krewniiznajomi.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "znaki_zodiaku_w")
@Immutable
public class ZnakiZodiakuWszyscy {

    @Id // dodajemy sztuczne @Id nawet jeśli to nie jest primary key w widoku (bo tam nie ma PK i tak)
    @Column(name = "id")
    private String id;
    @Column(name = "imie")
    private String imie;
    @Column(name = "nazwisko")
    private String nazwisko;
    @Column(name = "znak_zodiaku")
    private String znakZodiaku;

    public ZnakiZodiakuWszyscy() {
    }

    public ZnakiZodiakuWszyscy(String id, String imie, String nazwisko, String znakZodiaku) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.znakZodiaku = znakZodiaku;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getZnakZodiaku() {
        return znakZodiaku;
    }

    public void setZnakZodiaku(String znakZodiaku) {
        this.znakZodiaku = znakZodiaku;
    }

    @Override
    public String toString() {
        return "ZnakiZodiakuDzieci{" +
                "id='" + id + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", znakZodiaku='" + znakZodiaku + '\'' +
                '}';
    }
}
