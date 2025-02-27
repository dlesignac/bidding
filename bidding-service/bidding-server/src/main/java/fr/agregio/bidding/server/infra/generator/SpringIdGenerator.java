package fr.agregio.bidding.server.infra.generator;

import fr.agregio.bidding.server.tool.StringIdGenerator;
import org.springframework.util.IdGenerator;

public abstract class SpringIdGenerator
        implements StringIdGenerator {

    private final IdGenerator uuidGenerator;

    protected SpringIdGenerator(IdGenerator uuidGenerator) {
        this.uuidGenerator = uuidGenerator;
    }

    @Override
    public final String generate() {
        return uuidGenerator.generateId().toString();
    }

}
