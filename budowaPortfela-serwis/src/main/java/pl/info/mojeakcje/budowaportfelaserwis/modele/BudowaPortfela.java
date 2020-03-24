package pl.info.mojeakcje.budowaportfelaserwis.modele;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Robert Burek
 */
public class BudowaPortfela extends BaseEntity<String> {

    private String spolkaId;
    private String klientId;
    private LocalDate date;
    private LocalTime time;
    private String transakcjaId;

    /**
     * @return
     */
    public String gettransakcjaId() {
        return transakcjaId;
    }

    /**
     * @param transakcjaId
     */
    public void settransakcjaId(String transakcjaId) {
        this.transakcjaId = transakcjaId;
    }

    /**
     * @return
     */
    public String getSpolkaId() {
        return spolkaId;
    }

    /**
     * @param spolkaId
     */
    public void setSpolkaId(String spolkaId) {
        this.spolkaId = spolkaId;
    }

    /**
     * @return
     */
    public String getKlientId() {
        return klientId;
    }

    /**
     * @param klientId
     */
    public void setKlientId(String klientId) {
        this.klientId = klientId;
    }

    /**
     * @return
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * @return
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     * @param name
     * @param id
     * @param spolkaId
     * @param transakcjaId
     * @param klientId
     * @param time
     * @param date
     */
    public BudowaPortfela(String id, String name, String spolkaId, String transakcjaId, String klientId, LocalDate date, LocalTime time) {
        super(id, name);
        this.spolkaId = spolkaId;
        this.transakcjaId = transakcjaId;
        this.klientId = klientId;
        this.date = date;
        this.time = time;
    }

    /**
     * Przesłonięta metoda toString (), która zwraca ciąg znaków obiektu
     *
     * @return
     */
    @Override
    public String toString() {
        return new StringBuilder("{id: ").append(id).append(", name: ")
                .append(name).append(", klientId: ").append(klientId)
                .append(", spolkaId: ").append(spolkaId)
                .append(", transakcjaId: ").append(transakcjaId)
                .append(", date: ").append(date).append(", time: ").append(time).append("}").toString();
    }
}
