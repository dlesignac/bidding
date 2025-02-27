package fr.agregio.bidding.server.domain.bid;

import java.util.List;
import java.util.Objects;

public record BidCreationRequest(
        List<BidBlock> blocks) {

    public BidCreationRequest {
        Objects.requireNonNull(blocks);
    }

}
