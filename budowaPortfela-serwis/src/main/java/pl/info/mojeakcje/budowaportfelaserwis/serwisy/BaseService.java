package pl.info.mojeakcje.budowaportfelaserwis.serwisy;

import pl.info.mojeakcje.budowaportfelaserwis.repozytoria.Repository;

import java.util.Collection;

/**
 * @param <TE>
 * @param <T>
 * @author Robert Burek
 */
public abstract class BaseService<TE, T> extends ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> _repository;

    BaseService(Repository<TE, T> repository) {
        super(repository);
        _repository = repository;
    }

    /**
     * @param entity
     * @throws Exception
     */
    public void add(TE entity) throws Exception {
        _repository.add(entity);
    }

    /**
     * @return
     */
    public Collection<TE> getAll() {
        return _repository.getAll();
    }
}
