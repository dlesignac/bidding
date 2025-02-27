package fr.agregio.bidding.server.domain.supplier;

import fr.agregio.bidding.server.domain.market.MarketId;

import java.util.List;

public interface SupplierRepository {

    List<SupplierId> findAllIds(MarketId marketId);

}
