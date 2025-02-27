package fr.agregio.bidding.server.infra.persistence.jpa.supply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface SupplyDao extends JpaRepository<SupplyJpaDto, String> {

    List<SupplyJpaDto> findAllByBidBlockId(String bidBlockId);

    @Query(nativeQuery = true, value = """
                SELECT DISTINCT s.supplier_id FROM supply s
                    JOIN bid_block bb ON s.bid_block_id = bb.id
                    JOIN bid b ON bb.bid_id = b.id
                    WHERE b.market_id = :marketId
            """)
    List<String> findAllByMarketId(String marketId);

}
