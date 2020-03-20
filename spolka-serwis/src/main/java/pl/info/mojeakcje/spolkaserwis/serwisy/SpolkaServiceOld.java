package pl.info.mojeakcje.spolkaserwis.serwisy;

import pl.info.mojeakcje.spolkaserwis.modele.Spolka;
import pl.info.mojeakcje.spolkaserwis.repozytoria.SpolkaRepository;

import java.math.BigInteger;
import java.util.Collection;

public class SpolkaServiceOld extends BaseService<Spolka, BigInteger> {

    private SpolkaRepository<Spolka, String> spolkaRepository;

    public SpolkaServiceOld(SpolkaRepository repository) {
        super(repository);
        spolkaRepository = repository;
    }

    @Override
    public void add(Spolka spolka) throws Exception {
        if (spolkaRepository.containsName(spolka.getName())) {
            throw new Exception(String.format("Spółka o takiej nazwie już istnieje - %s", spolka.getName()));
        }

        if (spolka.getName() == null || "".equals(spolka.getName())) {
            throw new Exception("Nazwa spółki nie może być pusta ani równa null.");
        }
        super.add(spolka);
    }

    @Override
    public Collection<Spolka> getAll() {
        return super.getAll();
    }
}
