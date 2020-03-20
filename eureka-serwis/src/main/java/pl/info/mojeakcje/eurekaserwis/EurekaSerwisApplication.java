package pl.info.mojeakcje.eurekaserwis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaSerwisApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaSerwisApplication.class, args);
    }

}
