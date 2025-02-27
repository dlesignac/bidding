package fr.agregio.bidding.server.domain.bid;

import fr.agregio.bidding.server.domain.energy.Energy;
import fr.agregio.bidding.server.domain.supplier.SupplierId;

import java.util.Objects;

public record Supply(
        SupplierId supplierId,
        Energy energy) {

    public Supply {
        Objects.requireNonNull(supplierId);
        Objects.requireNonNull(energy);
    }

}
