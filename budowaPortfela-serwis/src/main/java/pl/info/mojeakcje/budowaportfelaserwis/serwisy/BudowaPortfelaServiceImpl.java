package pl.info.mojeakcje.budowaportfelaserwis.serwisy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.info.mojeakcje.budowaportfelaserwis.modele.BudowaPortfela;
import pl.info.mojeakcje.budowaportfelaserwis.modele.Entity;
import pl.info.mojeakcje.budowaportfelaserwis.repozytoria.BudowaPortfelaRepository;

/**
 *
 * @author Robert Burek
 */
@Service("budowaPortfelaService")
public class BudowaPortfelaServiceImpl extends BaseService<BudowaPortfela, String>
        implements BudowaPortfelaService {

    private BudowaPortfelaRepository<BudowaPortfela, String> budowaPortfelaRepository;

    /**
     *
     * @param budowaPortfelaRepository
     */
    @Autowired
    public BudowaPortfelaServiceImpl(BudowaPortfelaRepository<BudowaPortfela, String> budowaPortfelaRepository) {
        super(budowaPortfelaRepository);
        this.budowaPortfelaRepository = budowaPortfelaRepository;
    }

    @Override
    public void add(BudowaPortfela budowaPortfela) throws Exception {
        if (budowaPortfelaRepository.containsName(budowaPortfela.getName())) {
            throw new Exception(String.format("Jest już produkt o nazwie - %s", budowaPortfela.getName()));
        }

        if (budowaPortfela.getName() == null || "".equals(budowaPortfela.getName())) {
            throw new Exception("Nazwa budowaPortfela nie może być null lub ciągiem pustym.");
        }
        super.add(budowaPortfela);
    }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<BudowaPortfela> findByName(String name) throws Exception {
        return budowaPortfelaRepository.findByName(name);
    }

    /**
     *
     * @param budowaPortfela
     * @throws Exception
     */
    @Override
    public void update(BudowaPortfela budowaPortfela) throws Exception {
        budowaPortfelaRepository.update(budowaPortfela);
    }

    /**
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void delete(String id) throws Exception {
        budowaPortfelaRepository.remove(id);
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Entity findById(String id) throws Exception {
        return budowaPortfelaRepository.get(id);
    }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<BudowaPortfela> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        throw new UnsupportedOperationException("Jeszcze nie zaimplementowana.");
    }
}
