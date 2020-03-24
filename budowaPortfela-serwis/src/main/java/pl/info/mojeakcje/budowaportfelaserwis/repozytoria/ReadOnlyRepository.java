package pl.info.mojeakcje.budowaportfelaserwis.repozytoria;


import pl.info.mojeakcje.budowaportfelaserwis.modele.Entity;

import java.util.Collection;

/**
 * @param <TE>
 * @param <T>
 * @author Robert Burek
 */
public interface ReadOnlyRepository<TE, T> {

    /**
     * @param id
     * @return
     */
    boolean contains(T id);

    /**
     * @param id
     * @return
     */
    Entity get(T id);

    /**
     * @return
     */
    Collection<TE> getAll();
}
