package pl.info.mojeakcje.budowaportfelaserwis.modele;

/**
 * @param <T>
 * @author Robert Burek
 */
public abstract class BaseEntity<T> extends Entity<T> {

    private boolean isModified;

    /**
     * @param id
     * @param name
     */
    public BaseEntity(T id, String name) {
        super.id = id;
        super.name = name;
        isModified = false;
    }

    /**
     * @return
     */
    public boolean isModified() {
        return isModified;
    }

}
