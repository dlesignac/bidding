package fr.agregio.bidding.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.IdGenerator;
import org.springframework.util.JdkIdGenerator;

@SpringBootApplication
class BiddingServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BiddingServerApplication.class, args);
    }

    @Bean
    IdGenerator uuidGenerator() {
        return new JdkIdGenerator();
    }

}
