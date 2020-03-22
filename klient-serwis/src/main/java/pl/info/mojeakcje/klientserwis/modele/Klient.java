package pl.info.mojeakcje.klientserwis.modele;

/**
 * @author Robert Burek
 */
public class Klient extends BaseEntity<String> {

    private String address;
    private String city;
    private String noPhone;

    /**
     * @param name
     * @param id
     * @param address
     * @param city
     * @param noPhone
     */
    public Klient(String id, String name, String address, String city, String noPhone) {
        super(id, name);
        this.address = address;
        this.city = city;
        this.noPhone = noPhone;
    }

    /**
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return
     */
    public String getNoPhone() {
        return noPhone;
    }

    /**
     * @param noPhone
     */
    public void setNoPhone(String noPhone) {
        this.noPhone = noPhone;
    }

    /**
     * Overridden toString() method that return String presentation of the
     * Object
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
}
