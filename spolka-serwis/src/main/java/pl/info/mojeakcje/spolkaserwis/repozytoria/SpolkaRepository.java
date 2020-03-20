package pl.info.mojeakcje.spolkaserwis.repozytoria;

import java.util.Collection;

/**
 *
 * @author Robert Burek
 * @param <Spolka>>
 * @param <String>
 */
public interface SpolkaRepository<Spolka, String> extends Repository<Spolka, String> {

    /**
     *
     * @param name
     * @return
     */
    boolean containsName(String name);

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    Collection<Spolka> findByName(String name) throws Exception;
}
