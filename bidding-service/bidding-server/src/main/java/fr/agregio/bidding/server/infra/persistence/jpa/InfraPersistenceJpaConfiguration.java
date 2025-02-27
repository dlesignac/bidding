package fr.agregio.bidding.server.infra.persistence.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan
@EnableJpaRepositories
class InfraPersistenceJpaConfiguration {

}
