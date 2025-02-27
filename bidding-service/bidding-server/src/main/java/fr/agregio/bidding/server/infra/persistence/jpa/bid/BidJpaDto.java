package fr.agregio.bidding.server.infra.persistence.jpa.bid;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bid")
class BidJpaDto {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "market_id")
    private String marketId;

    public BidJpaDto() {

    }

    BidJpaDto(
            String id,
            String marketId) {
        this.id = id;
        this.marketId = marketId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

}
