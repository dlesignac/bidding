package fr.agregio.bidding.server.domain.bid;

import fr.agregio.bidding.server.domain.market.MarketId;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class BidService {

    private final BidRepository bidRepository;

    BidService(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    @Transactional(readOnly = true)
    public List<Bid> findAll(MarketId marketId) {
        return bidRepository.findAll(marketId);
    }

    @Transactional
    public Bid create(MarketId marketId, BidCreationRequest request) {
        var bid = new Bid(marketId, request.blocks());
        return bidRepository.create(bid);
    }

}
