package fr.agregio.bidding.server.infra.persistence.jpa.supply;

import fr.agregio.bidding.server.domain.market.MarketId;
import fr.agregio.bidding.server.domain.supplier.SupplierId;
import fr.agregio.bidding.server.domain.supplier.SupplierRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class JpaSupplierRepository implements SupplierRepository {

    private final SupplyDao supplyDao;

    JpaSupplierRepository(SupplyDao supplyDao) {
        this.supplyDao = supplyDao;
    }

    @Override
    public List<SupplierId> findAllIds(MarketId marketId) {
        return supplyDao.findAllByMarketId(marketId.value())
                .stream()
                .map(SupplierId::new)
                .toList();
    }

}
