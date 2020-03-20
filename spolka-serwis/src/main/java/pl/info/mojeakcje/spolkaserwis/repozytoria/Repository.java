package pl.info.mojeakcje.spolkaserwis.repozytoria;

public interface Repository<TE, T> extends ReadOnlyRepository<TE, T> {

    /**
     *
     * @param entity
     * @return
     */
    void add(TE entity);

    /**
     *
     * @param id
     * @return
     */
    void remove(T id);

    /**
     *
     * @param entity
     * @return
     */
    void update(TE entity);
}
