package pl.info.mojeakcje.spolkaserwis.repozytoria;

public interface DaneOSpolceRepository<DaneOSpolce, BigInteger> extends Repository<DaneOSpolce, BigInteger> {

    boolean containsInfo(String info);
}
