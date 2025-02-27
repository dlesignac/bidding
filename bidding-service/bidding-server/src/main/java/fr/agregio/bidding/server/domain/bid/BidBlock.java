package fr.agregio.bidding.server.domain.bid;

import fr.agregio.bidding.server.domain.energy.EnergyPrice;
import org.threeten.extra.Interval;

import java.util.List;
import java.util.Objects;

public record BidBlock(
        Interval instantInterval,
        EnergyPrice price,
        List<Supply> supplies) {

    public BidBlock {
        Objects.requireNonNull(instantInterval);
        Objects.requireNonNull(price);
        Objects.requireNonNull(supplies);
    }

}
