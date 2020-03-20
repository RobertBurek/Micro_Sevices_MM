package pl.info.mojeakcje.spolkaserwis.modele;

/**
 *
 * @author Robert Burek
 * @param <T>
 */
public class BaseEntity<T> extends Entity<T> {

    private boolean isModified;

    /**
     *
     * @param id
     * @param name
     */
    public BaseEntity(T id, String name) {
        super.id = id;
        super.name = name;
    }

    /**
     *
     * @return
     */
    public boolean isIsModified() {
        return isModified;
    }
}
