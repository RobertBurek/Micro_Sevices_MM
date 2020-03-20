package pl.info.mojeakcje.spolkaserwis.modele;

import java.math.BigDecimal;

public class InfoRynkoweOSpolce extends BaseEntity<BigDecimal> {

    private String infoRynkowe;
//    private String autor;
//    private String rodzaj;
//    private String inne;

    public InfoRynkoweOSpolce(String name, BigDecimal id, String infoRynkowe) {
        super(id, name);
        this.infoRynkowe = infoRynkowe;
    }

    public String getInfoRynkowe() {
        return infoRynkowe;
    }

    public void setInfoRynkowe(String infoRynkowe) {
        this.infoRynkowe = infoRynkowe;
    }
}
