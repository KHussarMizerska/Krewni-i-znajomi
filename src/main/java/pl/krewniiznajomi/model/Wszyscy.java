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
    private String name;
    @Column(name = "nazwisko")
    private String lastName;
    @Column(name = "data_ur")
    private Date bDate;

    public Wszyscy() {
    }

    public Wszyscy(String name, String lastName, Date bDate) {
        this.name = name;
        this.lastName = lastName;
        this.bDate = bDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBDate() {
        return bDate;
    }

    public void setBDate(Date bDate) {
        this.bDate = bDate;
    }

    @Override
    public String toString() {
        return "Wszyscy {" +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bDate=" + bDate +
                '}';
    }
}






