package pl.info.mojeakcje.spolkaserwis.kontrolery;


import org.junit.Before;
import pl.info.mojeakcje.spolkaserwis.modele.DaneOSpolce;
import pl.info.mojeakcje.spolkaserwis.modele.Entity;
import pl.info.mojeakcje.spolkaserwis.modele.Spolka;
import pl.info.mojeakcje.spolkaserwis.repozytoria.SpolkaRepository;
import pl.info.mojeakcje.spolkaserwis.serwisy.SpolkaService;
import pl.info.mojeakcje.spolkaserwis.serwisy.SpolkaServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Robert Burek
 */
public class SpolkaControllerTests extends AbstractSpolkaControllerTests {

    /**
     * Test tworzenia instancji Spolka
     */
    protected static final Spolka spolkaStaticInstance = new Spolka(SPOLKA,
            SPOLKA_NAME, new DaneOSpolce("PKO", new BigDecimal("1"), SPOLKA_DANEPODSTAWOWE));

    /**
     * Klasa TestSpolkaRepository
     */
    protected static class TestSpolkaRepository implements SpolkaRepository<Spolka, String> {

        private Map<String, Spolka> entities;

        /**
         * Konstruktor
         */
        public TestSpolkaRepository() {
            entities = new HashMap();
            Spolka spolka = new Spolka(SPOLKA, SPOLKA_NAME, new DaneOSpolce("PKO", new BigDecimal("1"), SPOLKA_DANEPODSTAWOWE));
            entities.put("1", spolka);
            spolka = new Spolka("2", "O Spolka", new DaneOSpolce("PKO", new BigDecimal("1"),"Jakaś branża"));
            entities.put("2", spolka);
        }

        /**
         * @param name
         * @return
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
        public void add(Spolka entity) {
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
        public void update(Spolka entity) {
            if (entities.containsKey(entity.getId())) {
                entities.put(entity.getId(), entity);
            }
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
        public Collection<Spolka> getAll() {
            return entities.values();
        }
    }

    /**
     * Inicjalizacja SpolkaRepository
     */
    protected TestSpolkaRepository testSpolkaRepository = new TestSpolkaRepository();

    /**
     * Inicjalizacja SpolkaService
     */
    protected SpolkaService spolkaService = new SpolkaServiceImpl(testSpolkaRepository);

    /**
     * Ustawienia na starcie
     */
    @Before
    public void setup() {
        spolkaController = new SpolkaController(spolkaService);
    }
}
