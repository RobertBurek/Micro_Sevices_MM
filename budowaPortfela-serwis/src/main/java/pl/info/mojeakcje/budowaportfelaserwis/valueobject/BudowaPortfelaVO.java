package pl.info.mojeakcje.budowaportfelaserwis.valueobject;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Robert Burek
 */
public class BudowaPortfelaVO {

    private String name;
    private String id;
    private String spolkaId;
    private String klientId;
    private LocalDate date;

    private LocalTime time;
    private String transakcjaId;

    /**
     * @return
     */
    public String getTransakcjaId() {
        return transakcjaId;
    }

    /**
     * @param transakcjaId
     */
    public void setTransakcjaId(String transakcjaId) {
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
     * Konstruktor bezparametrpwy
     */
    public BudowaPortfelaVO() {
    }

    /**
     * Konstruktor parametrowy
     *
     * @param name
     * @param id
     * @param spolkaId
     * @param klientId
     * @param time
     * @param date
     */
    public BudowaPortfelaVO(String id, String name, String spolkaId, String transakcjaId, String klientId, LocalDate date, LocalTime time) {
        this.id = id;
        this.name = name;
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

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
}
