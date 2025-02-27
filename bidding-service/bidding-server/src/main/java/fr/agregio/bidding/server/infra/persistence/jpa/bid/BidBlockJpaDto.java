package fr.agregio.bidding.server.infra.persistence.jpa.bid;

import fr.agregio.bidding.server.infra.persistence.jpa.time.InstantIntervalJpaDto;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "bid_block")
class BidBlockJpaDto {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "bid_id")
    private String bidId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "start", column = @Column(name = "instant_interval_start")),
            @AttributeOverride(name = "end", column = @Column(name = "instant_interval_end")),
    })
    private InstantIntervalJpaDto instantInterval;

    @Column(name = "price")
    private BigDecimal price;

    public BidBlockJpaDto() {

    }

    BidBlockJpaDto(
            String id,
            String bidId,
            InstantIntervalJpaDto instantInterval,
            BigDecimal price) {
        this.id = id;
        this.bidId = bidId;
        this.instantInterval = instantInterval;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBidId() {
        return bidId;
    }

    public void setBidId(String bidId) {
        this.bidId = bidId;
    }

    public InstantIntervalJpaDto getInstantInterval() {
        return instantInterval;
    }

    public void setInstantInterval(InstantIntervalJpaDto instantInterval) {
        this.instantInterval = instantInterval;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
