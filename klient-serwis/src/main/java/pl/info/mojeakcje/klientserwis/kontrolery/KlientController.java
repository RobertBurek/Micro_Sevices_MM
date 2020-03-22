package pl.info.mojeakcje.klientserwis.kontrolery;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.info.mojeakcje.klientserwis.modele.Entity;
import pl.info.mojeakcje.klientserwis.modele.Klient;
import pl.info.mojeakcje.klientserwis.serwisy.KlientService;
import pl.info.mojeakcje.klientserwis.valueobject.KlientVO;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Robert Burek
 */
@RestController
@RequestMapping("/v1/klienci")
public class KlientController {

    protected static final Logger logger = Logger.getLogger(KlientController.class.getName());

    protected KlientService klientService;

    /**
     * @param klientService
     */
    @Autowired
    public KlientController(KlientService klientService) {
        this.klientService = klientService;
    }

    /**
     * Pobierze wszystkich klientów.
     * Więc <code> http: //.../klienci/ </code> znajdzie wszystkich klientów.
     *     
     * @return niepustą kolekcję klientów.
     **/
    @GetMapping("/")
    public ResponseEntity<Collection<Klient>> getAll() {
        logger.info(String.format("klient-serwis getAll() wywołany: %s", klientService.getClass().getName()));
        Collection<Klient> klienci;
        try {
            klienci = klientService.getAll();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Wystąpił wyjątek wywołania metody findByName(). ", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return klienci.size() > 0 ? new ResponseEntity<>(klienci, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Pobierze klientów o podanej nazwie. Częściowe dopasowanie bez rozróżniania wielkości liter.
     * Więc <code> http: //.../klienci/rob </code> znajdzie wszystkich klientów z
     * wielkie i małe litery „rob” w ich nazwie.
     *
     * @param name      
     * @return niepustą kolekcję klientów.
     **/
    @GetMapping()
    public ResponseEntity<Collection<Klient>> findByName(@RequestParam("name") String name) {
        logger.info(String.format("klient-serwis findByName() wywołany: %s dla %s ", klientService.getClass().getName(), name));
        name = name.trim().toLowerCase();
        Collection<Klient> klienci;
        try {
            klienci = klientService.findByName(name);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Wystąpił wyjątek wywołania metody findByName(). ", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return klienci.size() > 0 ? new ResponseEntity<>(klienci, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Pobierze klientów o podanym identyfikatorze. <code> http: //.../v1/klienci/ {id} </code> będzie
     * zwraca klienta o podanym identyfikatorze.
     *     *
     *
     * @param id     * @return niepustą kolekcję klientów.
     *               
     **/
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public ResponseEntity<Entity> findById(@PathVariable("id") String id) {
        logger.info(String.format("klient-serwis findById() wywołany: %s dla %s ", klientService.getClass().getName(), id));
        id = id.trim();
        Entity klient;
        try {
            klient = klientService.findById(id);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Wystąpił wyjątek wywołania metody findById(). ", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return klient != null ? new ResponseEntity<>(klient, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Dodaj klienta z określonymi informacjami.
     *
     * @param klientVO
     * @return klient inny niż null.
     */
//    @RequestMapping(method = RequestMethod.POST)
    @PostMapping()
    public ResponseEntity<Klient> add(@RequestBody KlientVO klientVO) {
        logger.info(String.format("klient-serwis findById() wywołany: %s dla %s ", klientService.getClass().getName(), klientVO.getName()));
        System.out.println(klientVO);
        Klient klient = new Klient(null, null, null, null, null);
        BeanUtils.copyProperties(klientVO, klient);
        try {
            klientService.add(klient);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Wystąpił wyjątek podczas dodawania WalletBuild. ", ex);
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
