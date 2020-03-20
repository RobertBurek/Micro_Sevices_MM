package pl.info.mojeakcje.spolkaserwis.serwisy;

import pl.info.mojeakcje.spolkaserwis.repozytoria.Repository;

/**
 *
 * @author Robert Burek
 * @param <TE>
 * @param <T>
 */
public abstract class ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> repository;

    ReadOnlyBaseService(Repository<TE, T> repository) {
        this.repository = repository;
    }

}
