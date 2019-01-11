package pl.krewniiznajomi.model.dto;

public class StatDorosliDTO {

    private String wynik;

    private Long ile;

    public StatDorosliDTO() {
    }

    public StatDorosliDTO(String wynik, Long ile) {
        this.wynik = wynik;
        this.ile = ile;
    }

    public StatDorosliDTO(Integer wynikInteger, Long ile) {
        this.wynik = wynikInteger.toString();
        this.ile = ile;
    }

    public StatDorosliDTO(Long wynikLong, Long ile) {
        this.wynik = wynikLong.toString();
        this.ile = ile;
    }

    public String getWynik() {
        return wynik;
    }

    public void setWynik(String wynik) {
        this.wynik = wynik;
    }

    public Long getIle() {
        return ile;
    }

    public void setIle(Long ile) {
        this.ile = ile;
    }

    @Override
    public String toString() {
        return "StatDorosliDTO{" +
                "wynik='" + wynik + '\'' +
                ", ile=" + ile +
                '}';
    }
}
