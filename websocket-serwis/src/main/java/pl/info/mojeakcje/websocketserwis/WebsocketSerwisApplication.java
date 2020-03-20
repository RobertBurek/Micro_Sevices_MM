package pl.info.mojeakcje.websocketserwis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WebsocketSerwisApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketSerwisApplication.class, args);
    }

}
