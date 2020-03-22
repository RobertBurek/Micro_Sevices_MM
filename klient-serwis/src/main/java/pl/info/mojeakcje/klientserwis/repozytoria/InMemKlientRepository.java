package pl.info.mojeakcje.klientserwis.repozytoria;

import org.springframework.stereotype.Repository;
import pl.info.mojeakcje.klientserwis.modele.Entity;
import pl.info.mojeakcje.klientserwis.modele.Klient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Robert Burek
 */
@Repository("klientRepository")
public class InMemKlientRepository implements KlientRepository<Klient, String> {

    private Map<String, Klient> entities;

    /**
     * Zainicjuje repozytorium klientów w pamięci Map
     */
    public InMemKlientRepository() {
        entities = new HashMap();
        Klient klient = new Klient("1", "Robert Burek", "Address 111", "Warszawa", "555444888");
        entities.put("1", klient);
        Klient klient2 = new Klient("2", "Monika Jakaś", "Address 222", "Koszalin", "666888333");
        entities.put("2", klient2);
    }

    /**
     * Sprawdzi, czy podana nazwa użytkownika już istnieje.
     *
     * @param name      
     * @return true, jeśli już istnieje, w przeciwnym razie false
     **/
    @Override
    public boolean containsName(String name) {
        try {
            return this.findByName(name).size() > 0;
        } catch (Exception ex) {
            //Exception Handler
        }
        return false;
    }

    /**
     * @param entity
     */
    @Override
    public void add(Klient entity) {
        entities.put(entity.getId(), entity);
    }

    /**
     * @param id
     */
    @Override
    public void remove(String id) {
        if (entities.containsKey(id)) {
            entities.remove(id);
        }
    }

    /**
     * @param entity
     */
    @Override
    public void update(Klient entity) {
        if (entities.containsKey(entity.getId())) {
            entities.put(entity.getId(), entity);
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean contains(String id) {
        throw new UnsupportedOperationException("Jeszcze niezaimplementowana.");
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Entity get(String id) {
        return entities.get(id);
    }

    /**
     * @return
     */
    @Override
    public Collection<Klient> getAll() {
        return entities.values();
    }

    /**
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Klient> findByName(String name) throws Exception {
        Collection<Klient> klienci = new ArrayList();
        int noOfChars = name.length();
        entities.forEach((k, v) -> {
            if (v.getName().toLowerCase().contains(name.toLowerCase().subSequence(0, noOfChars))) {
                klienci.add(v);
            }
        });
        return klienci;
    }

}
