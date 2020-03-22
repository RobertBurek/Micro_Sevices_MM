package pl.info.mojeakcje.klientserwis.serwisy;

import pl.info.mojeakcje.klientserwis.modele.Entity;
import pl.info.mojeakcje.klientserwis.modele.Klient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * @author Robert Burek
 */
public interface KlientService {

    /**
     * @param walletBuild
     * @throws Exception
     */
    void add(Klient walletBuild) throws Exception;

    /**
     * @param walletBuild
     * @throws Exception
     */
    void update(Klient walletBuild) throws Exception;

    /**
     * @param id
     * @throws Exception
     */
    void delete(String id) throws Exception;

    /**
     * @param id
     * @return
     * @throws Exception
     */
    Entity findById(String id) throws Exception;

    /**
     * @param name
     * @return
     * @throws Exception
     */
    Collection<Klient> findByName(String name) throws Exception;

    /**
     * @param name
     * @return
     * @throws Exception
     */
    Collection<Klient> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;

    /**
     * @return
     * @throws Exception
     */
    Collection<Klient> getAll() throws Exception;
}
