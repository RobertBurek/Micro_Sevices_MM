package pl.info.mojeakcje.spolkaserwis.repozytoria;

import pl.info.mojeakcje.spolkaserwis.modele.Entity;

import java.util.Collection;

public interface ReadOnlyRepository<TE, T> {
    boolean contains(T id);

    Entity get(T id);

    Collection<TE> getAll();
}
