package pl.info.mojeakcje.spolkaserwis.modele;

import java.math.BigDecimal;

public class DaneOSpolce extends BaseEntity<BigDecimal> {

    private String danePodstawowe;
//    private String branza;
//    private String kapitał;
//    private String inne;

    public DaneOSpolce(String name, BigDecimal id, String danePodstawowe) {
        super(id, name);
        this.danePodstawowe = danePodstawowe;
    }

    public String getDanePodstawowe() {
        return danePodstawowe;
    }

    public void setDanePodstawowe(String danePodstawowe) {
        this.danePodstawowe = danePodstawowe;
    }
}
