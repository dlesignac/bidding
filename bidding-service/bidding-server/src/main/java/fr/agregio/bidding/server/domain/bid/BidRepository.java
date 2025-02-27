package fr.agregio.bidding.server.domain.bid;

import fr.agregio.bidding.server.domain.market.MarketId;

import java.util.List;

public interface BidRepository {

    List<Bid> findAll();

    List<Bid> findAll(MarketId marketId);

    Bid create(Bid bid);

}
