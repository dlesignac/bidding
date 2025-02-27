package fr.agregio.bidding.server.domain.market;

import java.util.Objects;

public record MarketId(String value) {

    public MarketId {
        Objects.requireNonNull(value);
    }

}
