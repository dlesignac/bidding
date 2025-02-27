package fr.agregio.bidding.server.domain.bid;

import fr.agregio.bidding.server.domain.market.MarketId;

import java.util.List;
import java.util.Objects;

public record Bid(
        MarketId marketId,
        List<BidBlock> blocks) {

    public Bid {
        Objects.requireNonNull(marketId);
        Objects.requireNonNull(blocks);
    }

}
