package fr.agregio.bidding.server.infra.persistence.jpa.supply;

import fr.agregio.bidding.server.domain.bid.Supply;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JpaSupplyRepository {

    private final SupplyDao supplyDao;
    private final SupplyJpaDtoMapper supplyJpaDtoMapper;

    JpaSupplyRepository(
            SupplyDao supplyDao,
            SupplyJpaDtoMapper supplyJpaDtoMapper) {
        this.supplyDao = supplyDao;
        this.supplyJpaDtoMapper = supplyJpaDtoMapper;
    }

    public List<Supply> saveAll(String bidBlockId, List<Supply> supplies) {
        return supplies.stream()
                .map(supply -> save(bidBlockId, supply))
                .toList();
    }

    public List<Supply> findAllByBidBlockId(String bidBlockId) {
        return supplyDao.findAllByBidBlockId(bidBlockId)
                .stream()
                .map(supplyJpaDtoMapper::from)
                .toList();
    }

    private Supply save(String bidBlockId, Supply supply) {
        var toBeSaved = supplyJpaDtoMapper.to(bidBlockId, supply);
        var saved = supplyDao.save(toBeSaved);
        return supplyJpaDtoMapper.from(saved);
    }

}
