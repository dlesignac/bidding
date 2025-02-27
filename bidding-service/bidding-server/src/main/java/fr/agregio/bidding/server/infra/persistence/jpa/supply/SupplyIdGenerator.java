package fr.agregio.bidding.server.infra.persistence.jpa.supply;

import fr.agregio.bidding.server.infra.generator.SpringIdGenerator;
import org.springframework.stereotype.Component;
import org.springframework.util.IdGenerator;

@Component
class SupplyIdGenerator extends SpringIdGenerator {

    SupplyIdGenerator(IdGenerator uuidGenerator) {
        super(uuidGenerator);
    }

}
