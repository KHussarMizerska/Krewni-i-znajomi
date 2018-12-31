package pl.krewniiznajomi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dorosli")
public class Dorosli {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dorosli")
    private int id;
    @Column(name = "imie")
    private String name;
    @Column(name = "nazwisko")
    private String lastName;
    @Column(name = "data_ur")
    private Date bDate;
    @Column(name = "plec")
    private String sex;

    public Dorosli() {
    }

    public Dorosli(int id, String name, String lastName, Date bDate, String sex) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.bDate = bDate;
        this.sex = sex;
    }

    public Dorosli(String name, String lastName, Date bDate, String sex) {
        this.name = name;
        this.lastName = lastName;
        this.bDate = bDate;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Dorosli{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bDate=" + bDate +
                ", sex='" + sex + '\'' +
                '}';
    }
}






