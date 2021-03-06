package pl.krewniiznajomi.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dzieci")

public class Dzieci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dzieci")
    private Long id;
    @Column(name = "imie")
    private String imie;
    @Column(name = "nazwisko")
    private String nazwisko;
    @Column(name = "data_ur")
    private Date dataUr;
    @Column(name = "plec")
    private String plec;
    @Transient
    @Column(name = "ile")
    private Long ile;

    public Dzieci() {
    }

    public Dzieci(Long id, String imie, String nazwisko, Date dataUr, String plec, Long ile) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUr = dataUr;
        this.plec = plec;
        this.ile = ile;
    }

    public Dzieci(String imie, Long ile) {
        this.imie = imie;
        this.ile = ile;
    }

    public Dzieci(Long id, String imie, String nazwisko, Date dataUr, String plec) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUr = dataUr;
        this.plec = plec;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setNazwisko(String nazwisko) { this.nazwisko = nazwisko; }

    public Date getDataUr() {
        return dataUr;
    }

    public void setDataUr(Date dataUr) {
        this.dataUr = dataUr;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public Long getIle() {
        return ile;
    }

    public void setIle(Long ile) {
        this.ile = ile;
    }

    @Override
    public String toString() {
        return "Dzieci{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataUr=" + dataUr +
                ", plec='" + plec + '\'' +
                ", ile=" + ile +
                '}';
    }
}






