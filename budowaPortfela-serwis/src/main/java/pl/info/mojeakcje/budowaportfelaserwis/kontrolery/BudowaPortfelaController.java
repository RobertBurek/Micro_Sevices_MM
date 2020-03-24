package pl.info.mojeakcje.budowaportfelaserwis.kontrolery;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.info.mojeakcje.budowaportfelaserwis.modele.BudowaPortfela;
import pl.info.mojeakcje.budowaportfelaserwis.modele.Entity;
import pl.info.mojeakcje.budowaportfelaserwis.serwisy.BudowaPortfelaService;
import pl.info.mojeakcje.budowaportfelaserwis.valueobject.BudowaPortfelaVO;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Robert Burek
 */
@RestController
@RequestMapping("/v1/budowaPortfela")
public class BudowaPortfelaController {

    /**
     *
     */
    protected static final Logger logger = Logger.getLogger(BudowaPortfelaController.class.getName());

    /**
     *
     */
    protected BudowaPortfelaService budowaPortfelaService;

    /**
     * @param budowaPortfelaService
     */
    @Autowired
    public BudowaPortfelaController(BudowaPortfelaService budowaPortfelaService) {
        this.budowaPortfelaService = budowaPortfelaService;
    }

    /**
     * Pobiera budowaPortfela dla podanej nazwy, niewrażliwe na wielkość znaków
     *
     * @param name
     * @return A non-null, niepusta kolekcja rezerwacji
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<BudowaPortfela>> findByName(@RequestParam("name") String name) {
        logger.info(String.format("booking-service findByName() wywołana:{} dla {} ", budowaPortfelaService.getClass().getName(), name));
        name = name.trim().toLowerCase();
        Collection<BudowaPortfela> budowyPortfeli;
        try {
            budowyPortfeli = budowaPortfelaService.findByName(name);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised findByName REST Call", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return budowyPortfeli.size() > 0 ? new ResponseEntity<>(budowyPortfeli, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Pobiera rezerwację o podanym ID
     *
     * @param id
     * @return Niepusta kolekcja rezerwacji.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Entity> findById(@PathVariable("id") String id) {
        logger.info(String.format("booking-service findById() invoked:{} for {} ", budowaPortfelaService.getClass().getName(), id));
        id = id.trim();
        Entity booking;
        try {
            booking = budowaPortfelaService.findById(id);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception raised findById REST Call {0}", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return booking != null ? new ResponseEntity<>(booking, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Dodaje budowaPortfela o podanej wartości.
     *
     * @param budowaPortfelaVO
     * @return BudowaPortfela
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<BudowaPortfela> add(@RequestBody BudowaPortfelaVO budowaPortfelaVO) {
        logger.info(String.format("budowaPortfela-serwis metoda add() wykonana: %s dla %s", budowaPortfelaService.getClass().getName(), budowaPortfelaVO.getName()));
        System.out.println(budowaPortfelaVO);
        BudowaPortfela budowaPortfela = new BudowaPortfela(null, null, null, null, null, null, null);
        BeanUtils.copyProperties(budowaPortfelaVO, budowaPortfela);
        try {
            budowaPortfelaService.add(budowaPortfela);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Wyjątek dodawania nowego budowaPortfela", ex);
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}