package fr.agregio.bidding.server.infra.persistence.jpa.supply;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "supply")
class SupplyJpaDto {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "bid_block_id")
    private String bidBlockId;

    @Column(name = "supplier_id")
    private String supplierId;

    @Column(name = "energy")
    private BigDecimal energy;

    public SupplyJpaDto() {

    }

    SupplyJpaDto(
            String id,
            String bidBlockId,
            String supplierId,
            BigDecimal energy) {
        this.id = id;
        this.bidBlockId = bidBlockId;
        this.supplierId = supplierId;
        this.energy = energy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBidBlockId() {
        return bidBlockId;
    }

    public void setBidBlockId(String bidBlockId) {
        this.bidBlockId = bidBlockId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public BigDecimal getEnergy() {
        return energy;
    }

    public void setEnergy(BigDecimal energy) {
        this.energy = energy;
    }

}
