package pl.info.mojeakcje.klientserwis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Robert Burek
 */
@SpringBootApplication
@EnableEurekaClient
public class KlientSerwisApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(KlientSerwisApplication.class, args);
    }

}
