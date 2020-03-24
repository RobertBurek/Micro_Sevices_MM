package pl.info.mojeakcje.budowaportfelaserwis.repozytoria;

import org.springframework.stereotype.Repository;
import pl.info.mojeakcje.budowaportfelaserwis.modele.BudowaPortfela;
import pl.info.mojeakcje.budowaportfelaserwis.modele.Entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Robert Burek
 */
@Repository("budowaPortfelaRepository")
public class InMemBudowaPortfelaRepository implements BudowaPortfelaRepository<BudowaPortfela, String> {

    private Map<String, BudowaPortfela> entities;

    /**
     * Zainicjuje repozytorium budowaPortfela w pamięci za pomocą przykładowej mapy
     */
    public InMemBudowaPortfelaRepository() {
        entities = new HashMap();
        BudowaPortfela budowaPortfela = new BudowaPortfela("1", "Portfel 1", "1", "1", "1", LocalDate.now(), LocalTime.now());
        entities.put("1", budowaPortfela);
        BudowaPortfela budowaPortfela2 = new BudowaPortfela("2", "Portfel 2", "2", "2", "2", LocalDate.now(), LocalTime.now());
        entities.put("2", budowaPortfela2);
    }

    /**
     * Sprawdź, czy podana nazwa budowaPortfela już istnieje.
     *
     * @param name
     * @return zwraca pradę gdy isnieje inaczej fałsz
     */
    @Override
    public boolean containsName(String name) {
        try {
            return this.findByName(name).size() > 0;
        } catch (Exception ex) {
            //Obsługa wyjątku
        }
        return false;
    }

    /**
     * @param entity
     */
    @Override
    public void add(BudowaPortfela entity) {
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
    public void update(BudowaPortfela entity) {
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
        throw new UnsupportedOperationException("Jeszcze nie zaimplementowana.");
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
    public Collection<BudowaPortfela> getAll() {
        return entities.values();
    }

    /**
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<BudowaPortfela> findByName(String name) throws Exception {
        Collection<BudowaPortfela> budowyPortfeli = new ArrayList();
        int noOfChars = name.length();
        entities.forEach((k, v) -> {
            if (v.getName().toLowerCase().contains(name.toLowerCase().subSequence(0, noOfChars))) {
                budowyPortfeli.add(v);
            }
        });
        return budowyPortfeli;
    }

}
