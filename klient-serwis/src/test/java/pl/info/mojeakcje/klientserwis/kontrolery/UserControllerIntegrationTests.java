package pl.info.mojeakcje.klientserwis.kontrolery;

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
import pl.info.mojeakcje.klientserwis.KlientSerwisApplication;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Robert Burek
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = KlientSerwisApplication.class)
@SpringBootTest(properties = "server.port=0")
public class UserControllerIntegrationTests {

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    public static final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${local.server.port}")
    private int port;

    /**
     * Test  GET /v1/klienci/{id} API
     */
    @Test
    public void testGetById() {
        //Wywołanie aplikacji
        Map<String, Object> response
                = restTemplate.getForObject("http://localhost:" + port + "/v1/klienci/1", Map.class);

        assertNotNull(response);

        //Zapewnienie odpowiedzi aplikacji
        String id = response.get("id").toString();
        assertNotNull(id);
        assertEquals("1", id);
        String name = response.get("name").toString();
        assertNotNull(name);
        assertEquals("Klient 1", name);
        boolean isModified = (boolean) response.get("isModified");
        assertEquals(false, isModified);
    }

    /**
     * Test GET /v1/klienci/{id} dla nieistniejącego klienta
     */
    @Test
    public void testGetById_NoContent() {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<Map> responseE = restTemplate.exchange("http://localhost:" + port + "/v1/klienci/105", HttpMethod.GET, entity, Map.class);

        assertNotNull(responseE);

        // Powinien nie zwracać treści, ponieważ nie ma klienta o identyfikatorze 105
        assertEquals(HttpStatus.NO_CONTENT, responseE.getStatusCode());
    }

    /**
     * Test the GET /v1/klienci API
     */
    @Test
    public void testGetByName() {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("name", "Klient");
        ResponseEntity<Map[]> responseE = restTemplate.exchange("http://localhost:" + port + "/v1/klienci/?name={name}", HttpMethod.GET, entity, Map[].class, uriVariables);

        assertNotNull(responseE);

        // Powino zwracać treści, ponieważ klient name istnieje
        assertEquals(HttpStatus.OK, responseE.getStatusCode());
        Map<String, Object>[] responses = responseE.getBody();
        assertNotNull(responses);

        assertTrue(responses.length == 2);

        Map<String, Object> response = responses[0];
        String id = response.get("id").toString();
        assertNotNull(id);
        assertEquals("1", id);
        String name = response.get("name").toString();
        assertNotNull(name);
        assertEquals("Klient 1", name);
        boolean isModified = (boolean) response.get("isModified");
        assertEquals(false, isModified);
    }

    /**
     * Testujemy interfejs POST /v1/klienci
     *
     * @throws JsonProcessingException
     */
    @Test
    public void testAdd() throws JsonProcessingException {

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "Klient 3");
        requestBody.put("id", "3");
        requestBody.put("address", "Adres klienta 3");
        requestBody.put("city", "Miasto");
        requestBody.put("phoneNo", "666333999");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        objectMapper.findAndRegisterModules();
        HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(requestBody), headers);

        ResponseEntity<Map> responseE = restTemplate.exchange("http://localhost:" + port + "/v1/klienci", HttpMethod.POST, entity, Map.class, Collections.EMPTY_MAP);

        assertNotNull(responseE);

        // Powinien byś zwrot statusu 201
        assertEquals(HttpStatus.CREATED, responseE.getStatusCode());

        //validating the newly created user using API call
        Map<String, Object> response
                = restTemplate.getForObject("http://localhost:" + port + "/v1/user/3", Map.class);

        assertNotNull(response);

        //Odpowiedź aplikacji
        String id = response.get("id").toString();
        assertNotNull(id);
        assertEquals("3", id);
        String name = response.get("name").toString();
        assertNotNull(name);
        assertEquals("Klient 3", name);
        boolean isModified = (boolean) response.get("isModified");
        assertEquals(false, isModified);
        String address = response.get("address").toString();
        assertNotNull(address);
        assertEquals("Adres klienta 3", address);
        String city = response.get("city").toString();
        assertNotNull(city);
        assertEquals("Miasto", city);
        String phoneNo = response.get("phoneNo").toString();
        assertNotNull(phoneNo);
        assertEquals("666333999", phoneNo);
    }

}
