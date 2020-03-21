package pl.info.mojeakcje.spolkaserwis.kontrolery;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.info.mojeakcje.spolkaserwis.modele.Entity;
import pl.info.mojeakcje.spolkaserwis.modele.Spolka;
import pl.info.mojeakcje.spolkaserwis.valueobject.SpolkaVO;

import java.util.Collection;
import java.util.logging.Logger;

/**
 * @author Robert Burek
 */
public abstract class AbstractSpolkaControllerTests {

    protected static final String SPOLKA = "1";
    protected static final String SPOLKA_NAME = "PKN";
    protected static final String SPOLKA_DANEPODSTAWOWE = "Branża paliwowa";

    @Autowired
    SpolkaController spolkaController;

    /**
     * Metoda testowa dla metody findById()
     */
    @Test
    public void testValidSpolkaById() {
        Logger.getGlobal().info("Poczatek testu testValidSpolkaById");
        ResponseEntity<Entity> spolka = spolkaController.findById(SPOLKA);

        Assert.assertEquals(HttpStatus.OK, spolka.getStatusCode());
        Assert.assertTrue(spolka.hasBody());
        Assert.assertNotNull(spolka.getBody());
        Assert.assertEquals(SPOLKA, spolka.getBody().getId());
        Assert.assertEquals(SPOLKA_NAME, spolka.getBody().getName());
        Logger.getGlobal().info("Koniec testu testValidSpolkaById");
    }

    /**
     * Metoda testowa dla metody findByName
     */
    @Test
    public void testValidSpolkaByName() {
        Logger.getGlobal().info("Początek testu testValidSpolkaByName");
        ResponseEntity<Collection<Spolka>> restaurants = spolkaController.findByName(SPOLKA_NAME);

        Assert.assertEquals(HttpStatus.OK, restaurants.getStatusCode());
        Assert.assertTrue(restaurants.hasBody());
        Assert.assertNotNull(restaurants.getBody());
        Assert.assertFalse(restaurants.getBody().isEmpty());
        Spolka spolka = (Spolka) restaurants.getBody().toArray()[0];
        Assert.assertEquals(SPOLKA, spolka.getId());
        Assert.assertEquals(SPOLKA_NAME, spolka.getName());
        Logger.getGlobal().info("Koniec testu testValidSpolkaByName");
    }

    /**
     * Metoda testowa dla metody add()
     */
    @Test
    public void testValidAddSpolka() {
        Logger.getGlobal().info("Początek testValidAddSpolka");
        SpolkaVO spolkaVO = new SpolkaVO();
        spolkaVO.setId("999");
        spolkaVO.setName("BWR");

        ResponseEntity<Spolka> spolki = spolkaController.add(spolkaVO);
        Assert.assertEquals(HttpStatus.CREATED, spolki.getStatusCode());
        Logger.getGlobal().info("Koniec testValidAddSpolka");
    }
}
