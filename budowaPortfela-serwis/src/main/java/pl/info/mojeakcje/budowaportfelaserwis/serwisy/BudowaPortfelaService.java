package pl.info.mojeakcje.budowaportfelaserwis.serwisy;

import pl.info.mojeakcje.budowaportfelaserwis.modele.BudowaPortfela;
import pl.info.mojeakcje.budowaportfelaserwis.modele.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * @author Robert Burek
 */
public interface BudowaPortfelaService {

    /**
     * @param budowaPortfela
     * @throws Exception
     */
    public void add(BudowaPortfela budowaPortfela) throws Exception;

    /**
     * @param budowaPortfela
     * @throws Exception
     */
    public void update(BudowaPortfela budowaPortfela) throws Exception;

    /**
     * @param id
     * @throws Exception
     */
    public void delete(String id) throws Exception;

    /**
     * @param id
     * @return
     * @throws Exception
     */
    public Entity findById(String id) throws Exception;

    /**
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<BudowaPortfela> findByName(String name) throws Exception;

    /**
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<BudowaPortfela> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
