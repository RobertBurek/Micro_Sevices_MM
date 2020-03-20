package pl.info.mojeakcje.spolkaserwis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpolkaSerwisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpolkaSerwisApplication.class, args);
    }

}
