package pl.info.mojeakcje.klientserwis.serwisy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.info.mojeakcje.klientserwis.modele.Entity;
import pl.info.mojeakcje.klientserwis.modele.Klient;
import pl.info.mojeakcje.klientserwis.repozytoria.KlientRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * @author Robert Burek
 */
@Service("klientService")
public class KlientServiceImpl extends BaseService<Klient, String>
        implements KlientService {

    private KlientRepository<Klient, String> klientRepository;

    /**
     * @param klientRepository
     */
    @Autowired
    public KlientServiceImpl(KlientRepository<Klient, String> klientRepository) {
        super(klientRepository);
        this.klientRepository = klientRepository;
    }

    @Override
    public void add(Klient klient) throws Exception {
        if (klientRepository.containsName(klient.getName())) {
            throw new Exception(String.format("Jest już produkt o nazwie - %s", klient.getName()));
        }
        if (klient.getName() == null || "".equals(klient.getName())) {
            throw new Exception("WalletBuild nazwa nie może być null lub pustym ciągiem.");
        }
        super.add(klient);
    }

    /**
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Klient> findByName(String name) throws Exception {
        return klientRepository.findByName(name);
    }

    /**
     * @param klient
     * @throws Exception
     */
    @Override
    public void update(Klient klient) throws Exception {
        klientRepository.update(klient);
    }

    /**
     * @param id
     * @throws Exception
     */
    @Override
    public void delete(String id) throws Exception {
        klientRepository.remove(id);
    }

    /**
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Entity findById(String id) throws Exception {
        return klientRepository.get(id);
    }

    /**
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Klient> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        throw new UnsupportedOperationException("Jeszcze nie zaimplementowano.");
    }
}
