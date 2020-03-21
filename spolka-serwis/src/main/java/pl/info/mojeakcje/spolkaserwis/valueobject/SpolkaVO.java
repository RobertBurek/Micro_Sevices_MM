package pl.info.mojeakcje.spolkaserwis.valueobject;

import pl.info.mojeakcje.spolkaserwis.modele.DaneDzienne;
import pl.info.mojeakcje.spolkaserwis.modele.DaneOSpolce;
import pl.info.mojeakcje.spolkaserwis.modele.InfoRynkoweOSpolce;
import pl.info.mojeakcje.spolkaserwis.modele.Transakcja;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Robert Burek
 */
public class SpolkaVO {

    private String id;
    private String name;
    private DaneOSpolce daneOSpolce;
    private List<InfoRynkoweOSpolce> listaInfoRynkowe = new ArrayList<>();
    private List<DaneDzienne> listaDaneDzien = new ArrayList<>();
    private List<Transakcja> listaTrans = new ArrayList<>();

    /**
     * Bezargumentowy konstruktor
     */
    public SpolkaVO() {
    }

    /**
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public DaneOSpolce getDaneOSpolce() {
        return daneOSpolce;
    }

    /**
     * @param daneOSpolce
     */
    public void setDaneOSpolce(DaneOSpolce daneOSpolce) {
        this.daneOSpolce = daneOSpolce;
    }

    /**
     * @return
     */
    public List<InfoRynkoweOSpolce> getListaInfoRynkowe() {
        return listaInfoRynkowe;
    }

    /**
     * @param listaInfoRynkowe
     */
    public void setListaInfoRynkowe(List<InfoRynkoweOSpolce> listaInfoRynkowe) {
        this.listaInfoRynkowe = listaInfoRynkowe;
    }

    /**
     * @return
     */
    public List<DaneDzienne> getListaDaneDzien() {
        return listaDaneDzien;
    }

    /**
     * @param listaDaneDzien
     */
    public void setListaDaneDzien(List<DaneDzienne> listaDaneDzien) {
        this.listaDaneDzien = listaDaneDzien;
    }

    /**
     * @return
     */
    public List<Transakcja> getListaTrans() {
        return listaTrans;
    }

    /**
     * @param listaTrans
     */
    public void setListaTrans(List<Transakcja> listaTrans) {
        this.listaTrans = listaTrans;
    }

    /**
     * Przesłonięta metoda toString (), która zwraca prezentację ciągu
     *
     * @return
     */
    @Override
    public String toString() {
        return new StringBuilder("{id: ").append(id)
                .append(", name: ").append(name)
                .append(", dane o spółce: ").append(daneOSpolce)
                .append(", ostatnie info rynkowe: ").append(listaInfoRynkowe.get(listaInfoRynkowe.size() - 1))
                .append(", ostatnie notowania: ").append(listaDaneDzien.get(listaDaneDzien.size() - 1))
                .append("}").toString();
    }
}
