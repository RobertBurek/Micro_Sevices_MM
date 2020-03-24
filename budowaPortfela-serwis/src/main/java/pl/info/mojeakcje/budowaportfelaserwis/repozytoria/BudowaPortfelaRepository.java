package pl.info.mojeakcje.budowaportfelaserwis.repozytoria;

import java.util.Collection;

/**
 * @param <BudowaPortfela>
 * @param <String>
 * @author Robert Burek
 */
public interface BudowaPortfelaRepository<BudowaPortfela, String> extends Repository<BudowaPortfela, String> {

    /**
     * @param name
     * @return
     */
    boolean containsName(String name);

    /**
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<BudowaPortfela> findByName(String name) throws Exception;
}
