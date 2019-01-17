package pl.krewniiznajomi.model;

import org.hibernate.annotations.Immutable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "znaki_zodiaku_d")
@Immutable
public class ZnakiZodiakuDorosli {


        @Id // dodajemy sztuczne @Id nawet jeśli to nie jest primary key w widoku (bo tam nie ma PK i tak)
        @Column(name = "id")
        private String id;
        @Column(name = "imie")
        private String imie;
        @Column(name = "nazwisko")
        private String nazwisko;
        @Column(name = "znak_zodiaku")
        private Date znakZodiaku;

        public ZnakiZodiakuDorosli() {
        }

        public ZnakiZodiakuDorosli(String id, String imie, String nazwisko, Date znakZodiaku) {
                this.id = id;
                this.imie = imie;
                this.nazwisko = nazwisko;
                this.znakZodiaku = znakZodiaku;
        }

        public ZnakiZodiakuDorosli(String imie, String nazwisko, Date znakZodiaku) {
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

        public Date getZnakZodiaku() {
                return znakZodiaku;
        }

        public void setZnakZodiaku(Date znakZodiaku) {
                this.znakZodiaku = znakZodiaku;
        }

        @Override
        public String toString() {
                return "ZnakiZodiakuDorosli{" +
                        "id='" + id + '\'' +
                        ", imie='" + imie + '\'' +
                        ", nazwisko='" + nazwisko + '\'' +
                        ", znakZodiaku=" + znakZodiaku +
                        '}';
        }
}
