package fr.agregio.bidding.server.domain.supplier;

import fr.agregio.bidding.server.domain.market.MarketId;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class SupplierService {

    private final SupplierRepository supplierRepository;

    SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Transactional(readOnly = true)
    public List<SupplierId> findAllIds(MarketId marketId) {
        return supplierRepository.findAllIds(marketId);
    }

}
