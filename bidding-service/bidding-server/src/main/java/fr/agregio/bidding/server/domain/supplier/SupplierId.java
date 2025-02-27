package fr.agregio.bidding.server.domain.supplier;

import java.util.Objects;

public record SupplierId(String value) {

    public SupplierId {
        Objects.requireNonNull(value);
    }

}
