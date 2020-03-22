package pl.info.mojeakcje.klientserwis.serwisy;

import pl.info.mojeakcje.klientserwis.repozytoria.Repository;

/**
 * @param <TE>
 * @param <T>
 * @author Robert Burek
 */
public abstract class ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> repository;

    ReadOnlyBaseService(Repository<TE, T> repository) {
        this.repository = repository;
    }
}
