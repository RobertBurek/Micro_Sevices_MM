package pl.info.mojeakcje.budowaportfelaserwis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BudowaportfelaSerwisApplication {

    public static void main(String[] args) {
        SpringApplication.run(BudowaportfelaSerwisApplication.class, args);
    }

}
