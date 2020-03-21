package pl.info.mojeakcje.spolkaserwis.kontrolery;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pl.info.mojeakcje.spolkaserwis.SpolkaSerwisApplication;
import pl.info.mojeakcje.spolkaserwis.modele.Spolka;

import java.math.BigInteger;
import java.util.*;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Robert Burek
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpolkaSerwisApplication.class)
@SpringBootTest(properties = "server.port=0")
public class SpolkaControllerIntegrationTests extends
        AbstractSpolkaControllerTests {

    private final TestRestTemplate testRestTemplate = new TestRestTemplate();

    public static final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${local.server.port}")
    private int port;

    /**
     * Test GET /v1/spolki/{id}
     */
    @Test
    public void testGetById() {
        //Wywołanie aplikacji
        Map<String, Object> response
                = testRestTemplate.getForObject("http://localhost:" + port + "/v1/spolki/1", Map.class);

        assertNotNull(response);

        //Zapewnienie odpowiedzi aplikacji
        String id = response.get("id").toString();
        assertNotNull(id);
        assertEquals("1", id);
        String name = response.get("name").toString();
        assertNotNull(name);
        assertEquals("PKN", name);
        boolean isModified = (boolean) response.get("isModified");
        assertEquals(false, isModified);
        List<Spolka> spolki = (List<Spolka>) response.get("spolki");
        assertNull(spolki);
    }

    /**
     * Przetestuj interfejs GET /v1/spolki/{id} pod kątem braku zawartości
     */
    @Test
    public void testGetById_NoContent() {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<Map> responseE = testRestTemplate.exchange("http://localhost:" + port + "/v1/spolki/105", HttpMethod.GET, entity, Map.class);

        assertNotNull(responseE);

        // Powinien nie zwracać treści, ponieważ nie ma spolki o identyfikatorze 105
        assertEquals(HttpStatus.NO_CONTENT, responseE.getStatusCode());
    }

    /**
     * Przetestuj interfejs GET /v1/spolki?name=
     */
    @Test
    public void testGetByName() {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("name", "PK");
        ResponseEntity<Map[]> responseE = testRestTemplate.exchange("http://localhost:" + port + "/v1/spolki?name={name}", HttpMethod.GET, entity, Map[].class, uriVariables);

        assertNotNull(responseE);

        // Powino zwracać treści, ponieważ spolka PKN istnieje
        assertEquals(HttpStatus.OK, responseE.getStatusCode());
        Map<String, Object>[] responses = responseE.getBody();
        assertNotNull(responses);

        // Zakładając, że istnieje tylko jedna instancja dla nazwy spolki zawierającej słowo „PK”
        assertTrue(responses.length == 1);

        Map<String, Object> response = responses[0];
        String id = response.get("id").toString();
        assertNotNull(id);
        assertEquals("1", id);
        String name = response.get("name").toString();
        assertNotNull(name);
        assertEquals("PKN", name);
        boolean isModified = (boolean) response.get("isModified");
        assertEquals(false, isModified);
        List<Spolka> spolkaList = (List<Spolka>) response.get("spolki");
        assertNull(spolkaList);
    }

    /**
     * Testujemy interfejs POST /v1/społki
     *
     * @throws JsonProcessingException
     */
    @Test
    public void testAdd() throws JsonProcessingException {

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "SPO");
        requestBody.put("id", "11");
        Map<String, Object> spolka1 = new HashMap<>();
        spolka1.put("name", "Spolka 1");
        spolka1.put("id", BigInteger.ONE);
        Map<String, Object> spolka2 = new HashMap<>();
        spolka2.put("name", "Spolka 2");
        spolka2.put("id", BigInteger.valueOf(2));
        Map<String, Object> spolka3 = new HashMap<>();
        spolka3.put("name", "Spolka 3");
        spolka3.put("id", BigInteger.valueOf(3));
        List<Map<String, Object>> spolki1 = new ArrayList();
        spolki1.add(spolka1);
        spolki1.add(spolka2);
        spolki1.add(spolka3);
        requestBody.put("spolki", spolki1);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(requestBody), headers);

        ResponseEntity<Map> responseE = testRestTemplate.exchange("http://localhost:" + port + "/v1/spolki", HttpMethod.POST, entity, Map.class, Collections.EMPTY_MAP);

        assertNotNull(responseE);

        // Powinien byś zwrot statusu 201
        assertEquals(HttpStatus.CREATED, responseE.getStatusCode());

        //sprawdzanie poprawności nowo utworzonej spolki za pomocą wywołania aplikacji
        Map<String, Object> response
                = testRestTemplate.getForObject("http://localhost:" + port + "/v1/spolki/11", Map.class);

        assertNotNull(response);

        //Odpowiedź aplikacji
        String id = response.get("id").toString();
        assertNotNull(id);
        assertEquals("11", id);
        String name = response.get("name").toString();
        assertNotNull(name);
        assertEquals("BWR", name);
        boolean isModified = (boolean) response.get("isModified");
        assertEquals(false, isModified);
        List<Map<String, Object>> spolki2 = (List<Map<String, Object>>) response.get("spolki");
        assertNotNull(spolki2);
        assertEquals(spolki2.size(), 3);
        spolki2.stream().forEach((spolka) -> {
            assertNotNull(spolka);
            assertNotNull(spolka.get("name"));
            assertNotNull(spolka.get("id"));
            assertTrue((Integer) spolka.get("ilosc") > 0);
        });
    }

}
