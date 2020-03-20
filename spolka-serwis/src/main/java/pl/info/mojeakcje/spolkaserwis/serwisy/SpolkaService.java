package pl.info.mojeakcje.spolkaserwis.serwisy;

import pl.info.mojeakcje.spolkaserwis.modele.Entity;
import pl.info.mojeakcje.spolkaserwis.modele.Spolka;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * @author Robert Burek
 */
public interface SpolkaService {

    /**
     * @param spolka
     * @throws Exception
     */
    void add(Spolka spolka) throws Exception;

    /**
     * @param spolka
     * @throws Exception
     */
    void update(Spolka spolka) throws Exception;

    /**
     * @param id
     * @throws Exception
     */
    void delete(String id) throws Exception;

    /**
     * @param spolkaId
     * @return
     * @throws Exception
     */
    Entity findById(String spolkaId) throws Exception;

    /**
     * @param name
     * @return
     * @throws Exception
     */
    Collection<Spolka> findByName(String name) throws Exception;

    /**
     * @param name
     * @return
     * @throws Exception
     */
    Collection<Spolka> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;

    /**
     * @return
     * @throws Exception
     */
    Collection<Spolka> getAll() throws Exception;
}
