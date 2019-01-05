package pl.krewniiznajomi.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name = "rocznice")
@Immutable

public class Rocznice {

    @Id // dodajemy sztuczne @Id nawet jeśli to nie jest primary key w widoku (bo tam nie ma PK i tak)
    @Column(name = "imie_zony")
    private String imieZony;
    @Column(name = "nazwisko_zony")
    private String nazwiskoZony;
    @Column(name = "imie_meza")
    private String imieMeza;
    @Column(name = "nazwisko_meza")
    private String nazwiskoMeza;
    @Column(name = "data_slubu")
    private Date dataSlubu;
    @Column(name = "nr_rocznicy")
    private Long nrRocznicy;
    @Column(name = "nazwa_rocznicy")
    private String nazwaRocznicy;

    public Rocznice() {
    }

    public Rocznice(String imieZony, String nazwiskoZony, String imieMeza, String nazwiskoMeza, Date dataSlubu, Long nrRocznicy, String nazwaRocznicy) {
        this.imieZony = imieZony;
        this.nazwiskoZony = nazwiskoZony;
        this.imieMeza = imieMeza;
        this.nazwiskoMeza = nazwiskoMeza;
        this.dataSlubu = dataSlubu;
        this.nrRocznicy = nrRocznicy;
        this.nazwaRocznicy = nazwaRocznicy;
    }

    public String getImieZony() {
        return imieZony;
    }

    public void setImieZony(String imieZony) {
        this.imieZony = imieZony;
    }

    public String getNazwiskoZony() {
        return nazwiskoZony;
    }

    public void setNazwiskoZony(String nazwiskoZony) {
        this.nazwiskoZony = nazwiskoZony;
    }

    public String getImieMeza() {
        return imieMeza;
    }

    public void setImieMeza(String imieMeza) {
        this.imieMeza = imieMeza;
    }

    public String getNazwiskoMeza() {
        return nazwiskoMeza;
    }

    public void setNazwiskoMeza(String nazwiskoMeza) {
        this.nazwiskoMeza = nazwiskoMeza;
    }

    public Date getDataSlubu() {
        return dataSlubu;
    }

    public void setDataSlubu(Date dataSlubu) {
        this.dataSlubu = dataSlubu;
    }

    public Long getNrRocznicy() {
        return nrRocznicy;
    }

    public void setNrRocznicy(Long nrRocznicy) {
        this.nrRocznicy = nrRocznicy;
    }

    public String getNazwaRocznicy() {
        return nazwaRocznicy;
    }

    public void setNazwaRocznicy(String nazwaRocznicy) {
        this.nazwaRocznicy = nazwaRocznicy;
    }
}
