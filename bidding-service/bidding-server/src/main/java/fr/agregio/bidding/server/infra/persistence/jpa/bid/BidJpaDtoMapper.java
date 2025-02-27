package fr.agregio.bidding.server.infra.persistence.jpa.bid;

import fr.agregio.bidding.server.domain.bid.Bid;
import fr.agregio.bidding.server.domain.bid.BidBlock;
import fr.agregio.bidding.server.domain.market.MarketId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class BidJpaDtoMapper {

    private final BidIdGenerator idGenerator;

    BidJpaDtoMapper(BidIdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public Bid from(BidJpaDto dto, List<BidBlock> blocks) {
        var marketId = new MarketId(dto.getMarketId());
        return new Bid(marketId, blocks);
    }

    public BidJpaDto to(Bid bid) {
        var id = idGenerator.generate();
        var marketId = bid.marketId().value();
        return new BidJpaDto(id, marketId);
    }

}
