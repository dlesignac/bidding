package fr.agregio.bidding.server.infra.persistence.jpa.bid;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface BidDao extends JpaRepository<BidJpaDto, String> {

    List<BidJpaDto> findAllByMarketId(String marketId);

}
