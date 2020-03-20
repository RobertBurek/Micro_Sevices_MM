package pl.info.mojeakcje.spolkaserwis.modele;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Robert Burek
 */
public class Spolka extends BaseEntity<String> {

    private DaneOSpolce daneOSpolce;
    private List<InfoRynkoweOSpolce> listaInfoRynkowe = new ArrayList<>();
    private List<DaneDzienne> listaDaneDzien = new ArrayList<>();
    private List<Transakcja> listaTrans = new ArrayList<>();

    public Spolka(String id, String name, DaneOSpolce daneOSpolce) {
        super(id, name);
        this.daneOSpolce = daneOSpolce;
    }

    public DaneOSpolce getDaneOSpolce() {
        return daneOSpolce;
    }

    public void setDaneOSpolce(DaneOSpolce daneOSpolce) {
        this.daneOSpolce = daneOSpolce;
    }

    public List<InfoRynkoweOSpolce> getListaInfoRynkowe() {
        return listaInfoRynkowe;
    }

    public void setListaInfoRynkowe(List<InfoRynkoweOSpolce> listaInfoRynkowe) {
        this.listaInfoRynkowe = listaInfoRynkowe;
    }

    public List<DaneDzienne> getListaDaneDzien() {
        return listaDaneDzien;
    }

    public void setListaDaneDzien(List<DaneDzienne> listaDaneDzien) {
        this.listaDaneDzien = listaDaneDzien;
    }

    public List<Transakcja> getListaTrans() {
        return listaTrans;
    }

    public void setListaTrans(List<Transakcja> listaTrans) {
        this.listaTrans = listaTrans;
    }
}
