package pl.info.mojeakcje.spolkaserwis.modele;

import java.math.BigInteger;

public class DaneDzienne extends BaseEntity<BigInteger> {

    private String daneDzienne;
//    private String otwarcie;
//    private String maksimum;
//    private String minimum;
//    private String zamkniecie;
//    private String wolumen;

    public DaneDzienne(String name, BigInteger id, String daneDzienne) {
        super(id, name);
        this.daneDzienne = daneDzienne;
    }

    public String getDaneDzienne() {
        return daneDzienne;
    }

    public void setDaneDzienne(String daneDzienne) {
        this.daneDzienne = daneDzienne;
    }
}
