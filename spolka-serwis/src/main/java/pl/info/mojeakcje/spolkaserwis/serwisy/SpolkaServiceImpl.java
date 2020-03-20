package pl.info.mojeakcje.spolkaserwis.serwisy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.info.mojeakcje.spolkaserwis.kontrolery.SpolkaController;
import pl.info.mojeakcje.spolkaserwis.modele.Entity;
import pl.info.mojeakcje.spolkaserwis.modele.Spolka;
import pl.info.mojeakcje.spolkaserwis.repozytoria.SpolkaRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author Robert Burek
 */
@Service("spolkaService")
public class SpolkaServiceImpl extends BaseService<Spolka, String> implements SpolkaService {

    protected static final Logger logger = Logger.getLogger(SpolkaController.class.getName());

    private SpolkaRepository<Spolka, String> spolkaRepository;

    /**
     * @param spolkaRepository
     */
    @Autowired
    public SpolkaServiceImpl(SpolkaRepository<Spolka, String> spolkaRepository) {
        super(spolkaRepository);
        this.spolkaRepository = spolkaRepository;
    }

    @Override
    public void add(Spolka restaurant) throws Exception {
        if (spolkaRepository.containsName(restaurant.getName())) {
            throw new Exception(String.format("Istnieje już spółka o nazwie - %s", restaurant.getName()));
        }

        if (restaurant.getName() == null || "".equals(restaurant.getName())) {
            throw new Exception("Nazwa spółki nie może być null ani pustej wartości.");
        }
        super.add(restaurant);
    }

    /**
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Spolka> findByName(String name) throws Exception {
        return spolkaRepository.findByName(name);
    }

    /**
     * @param spolka
     * @throws Exception
     */
    @Override
    public void update(Spolka spolka) throws Exception {
        spolkaRepository.update(spolka);
    }

    /**
     * @param id
     * @throws Exception
     */
    @Override
    public void delete(String id) throws Exception {
        spolkaRepository.remove(id);
    }

    /**
     * @param spolkaId
     * @return
     * @throws Exception
     */
    @Override
    public Entity findById(String spolkaId) throws Exception {
        return spolkaRepository.get(spolkaId);
    }

    /**
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Spolka> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        throw new UnsupportedOperationException("Metoda jeszcze nie zaimplementowana.");
    }

    @Override
    public Collection<Spolka> getAll() {
        return super.getAll();
    }
}
