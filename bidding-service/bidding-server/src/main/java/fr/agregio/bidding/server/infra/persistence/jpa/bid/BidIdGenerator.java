package fr.agregio.bidding.server.infra.persistence.jpa.bid;

import fr.agregio.bidding.server.infra.generator.SpringIdGenerator;
import org.springframework.stereotype.Component;
import org.springframework.util.IdGenerator;

@Component
class BidIdGenerator extends SpringIdGenerator {

    BidIdGenerator(IdGenerator uuidGenerator) {
        super(uuidGenerator);
    }

}
