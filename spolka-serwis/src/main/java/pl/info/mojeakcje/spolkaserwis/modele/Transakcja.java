package pl.info.mojeakcje.spolkaserwis.modele;

import java.math.BigDecimal;

public class Transakcja extends BaseEntity<BigDecimal> {

    private String transakcja;
//    private String dataTrans;
//    private String timeTrans;
//    private String kursTrans;
//    private String wolumenTrans;

    public Transakcja(String name, BigDecimal id, String transakcja) {
        super(id, name);
        this.transakcja = transakcja;
    }

    public String getTransakcja() {
        return transakcja;
    }

    public void setTransakcja(String transakcja) {
        this.transakcja = transakcja;
    }
}
