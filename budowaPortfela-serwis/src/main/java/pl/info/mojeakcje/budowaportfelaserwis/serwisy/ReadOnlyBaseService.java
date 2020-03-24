package pl.info.mojeakcje.budowaportfelaserwis.serwisy;

import pl.info.mojeakcje.budowaportfelaserwis.repozytoria.Repository;

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
