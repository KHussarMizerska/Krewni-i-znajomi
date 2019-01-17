package pl.krewniiznajomi.model;

import javax.persistence.*;

@Entity
@Table(name = "rodzice_dzieci")

public class RodziceDzieci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rd")
    private Long idRD;
    @Column(name = "id_dzieci")
    private Long idDzieci;
    @Column(name = "id_dorosli")
    private Long idDorosli;

    public RodziceDzieci() {
    }

    public RodziceDzieci(Long idRD, Long idDzieci, Long idDorosli) {
        this.idRD = idRD;
        this.idDzieci = idDzieci;
        this.idDorosli = idDorosli;
    }

    public Long getIdRD() {
        return idRD;
    }

    public void setIdRD(Long idRD) {
        this.idRD = idRD;
    }

    public Long getIdDzieci() {
        return idDzieci;
    }

    public void setIdDzieci(Long idDzieci) {
        this.idDzieci = idDzieci;
    }

    public Long getIdDorosli() {
        return idDorosli;
    }

    public void setIdDorosli(Long idDorosli) {
        this.idDorosli = idDorosli;
    }

    @Override
    public String toString() {
        return "RodziceDzieci{" +
                "idRD=" + idRD +
                ", idDzieci=" + idDzieci +
                ", idDorosli=" + idDorosli +
                '}';
    }
}
