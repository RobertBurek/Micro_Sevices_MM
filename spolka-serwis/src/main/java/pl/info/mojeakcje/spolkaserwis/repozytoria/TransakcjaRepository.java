package pl.info.mojeakcje.spolkaserwis.repozytoria;

public interface TransakcjaRepository<Transakcja, BigInteger> extends Repository<Transakcja, BigInteger> {

    boolean containsInfo(String info);
}
