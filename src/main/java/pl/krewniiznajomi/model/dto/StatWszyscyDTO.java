package pl.krewniiznajomi.model.dto;

public class StatWszyscyDTO {

    private String wynik;

    private Long ile;

    public StatWszyscyDTO() {
    }

    public StatWszyscyDTO(Integer wynikInteger, Long ile) {
        this.wynik = wynikInteger.toString();
        this.ile = ile;
    }

    public StatWszyscyDTO(String wynik, Long ile) {
        this.wynik = wynik;
        this.ile = ile;
    }

    public StatWszyscyDTO(Long wynikLong, Long ile) {
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
        return "StatWszyscyDTO{" +
                "wynik='" + wynik + '\'' +
                ", ile=" + ile +
                '}';
    }
}
