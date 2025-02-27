package fr.agregio.bidding.server.infra.persistence.jpa.bid;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface BidBlockDao extends JpaRepository<BidBlockJpaDto, String> {

    List<BidBlockJpaDto> findAllByBidId(String bidId);

}
