package pl.info.mojeakcje.spolkaserwis.repozytoria;

import org.springframework.stereotype.Repository;
import pl.info.mojeakcje.spolkaserwis.kontrolery.SpolkaController;
import pl.info.mojeakcje.spolkaserwis.modele.DaneOSpolce;
import pl.info.mojeakcje.spolkaserwis.modele.Spolka;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Repository("spolkaRepository")
public class InMemSpolkaRepository implements SpolkaRepository<Spolka, String> {

    protected static final Logger logger = Logger.getLogger(SpolkaController.class.getName());

    private Map<String, Spolka> entities;

    /**
     * Inicjalizacja danych spółek w pamięci w kolecji Map
     */
    public InMemSpolkaRepository() {
        entities = new HashMap();
        Spolka spolka = new Spolka("1", "CDR", new DaneOSpolce("CDR", new BigDecimal("1"), "Gry komputerowe"));
        entities.put("1", spolka);
        spolka = new Spolka("2", "KGH", new DaneOSpolce("KGH", new BigDecimal("2"), "Polska miedż"));
        entities.put("2", spolka);
        spolka = new Spolka("3", "PKN", new DaneOSpolce("PKN", new BigDecimal("3"), "PKN ORLEN - paliwa"));
        entities.put("3", spolka);
        spolka = new Spolka("4", "PGN", new DaneOSpolce("PGN", new BigDecimal("4"), "Gazownictwo"));
        entities.put("4", spolka);
        spolka = new Spolka("5", "PKO", new DaneOSpolce("PKO", new BigDecimal("5"), "PKO BB - Bank Polski"));
        entities.put("5", spolka);
        spolka = new Spolka("6", "PEO", new DaneOSpolce("PEO", new BigDecimal("6"), "PEKAO SA - drugi bank polski"));
        entities.put("6", spolka);
        spolka = new Spolka("7", "LTS", new DaneOSpolce("LTS", new BigDecimal("7"), "Lotos - paliwa"));
        entities.put("7", spolka);
        spolka = new Spolka("8", "CCC", new DaneOSpolce("CCC", new BigDecimal("8"), "Obuwie i ciuchy"));
        entities.put("8", spolka);
        spolka = new Spolka("9", "PGE", new DaneOSpolce("PGE", new BigDecimal("9"), "Energetyka"));
        entities.put("9", spolka);
    }

    /**
     * Sprawdza, czy podana nazwa spółki już istnieje.
     *
     * @param name
     * @return prawda, jeśli już istnieje, w przeciwnym razie fałsz.
     */
    @Override
    public boolean containsName(String name) {
        try {
            return this.findByName(name).size() > 0;
        } catch (Exception ex) {
            logger.info("Błąd w metodzie containsName(s)!");
        }
        return false;
    }

    /**
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Spolka> findByName(String name) throws Exception {
        Collection<Spolka> spolki = new ArrayList();
        int noOfChars = name.length();
        entities.forEach((k, v) -> {
            if (v.getName().toLowerCase().contains(name.subSequence(0, noOfChars))) {
                spolki.add(v);
            }
        });
        return spolki;
    }

    /**
     * @param entity
     */
    @Override
    public void add(Spolka entity) {
        entities.put(entity.getName(), entity);
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
    public void update(Spolka entity) {
        if (entities.containsKey(entity.getName())) {
            entities.put(entity.getName(), entity);
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean contains(String id) {
        throw new UnsupportedOperationException("Metoda contains() nie została zaimplementowana.");
        // TODO zaimplementować
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Spolka get(String id) {
        return entities.get(id);
    }

    /**
     * @return
     */
    @Override
    public Collection<Spolka> getAll() {
        return entities.values();
    }

}
