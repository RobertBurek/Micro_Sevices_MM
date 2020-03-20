package pl.info.mojeakcje.spolkaserwis.repozytoria;

public interface DaneDzienneRepository<DaneDzienne, BigInteger> extends Repository<DaneDzienne, BigInteger> {

    boolean containsInfo(String info);
}
