package pl.info.mojeakcje.klientserwis.valueobject;

/**
 *
 * @author Robert Burek
 */
public class KlientVO {

    private String name;
    private String id;
    private String address;
    private String city;
    private String noPhone;

    /**
     * Custom Constructor
     *
     * @param name
     * @param id
     * @param address
     * @param city
     * @param noPhone
     */
    public KlientVO(String id, String name, String address, String city, String noPhone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.noPhone = noPhone;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     */
    public String getNoPhone() {
        return noPhone;
    }

    /**
     *
     * @param noPhone
     */
    public void setNoPhone(String noPhone) {
        this.noPhone = noPhone;
    }

    /**
     * Przesłonięta metoda toString (), która zwraca prezentację ciągu
     *
     * @return
     */
    @Override
    public String toString() {
        return new StringBuilder("{id: ").append(id).append(", name: ")
                .append(name).append(", address: ").append(address)
                .append(", city: ").append(city)
                .append(", noPhone: ").append(noPhone).append("}").toString();
    }

    /**
     * Bezargumentowy konstruktor
     */
    public KlientVO() {
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
}
