package pl.info.mojeakcje.klientserwis.repozytoria;

import java.util.Collection;

/**
 * @param <Klient>  //Kient
 * @param <String>
 * @author Robert Burek
 */
//public interface KlientRepository<WalletBuild, String> extends Repository<WalletBuild, String> {
public interface KlientRepository<Klient, String> extends Repository<Klient, String> {

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
//    Collection<WalletBuild> findByName(String name) throws Exception;
    Collection<Klient> findByName(String name) throws Exception;
}
