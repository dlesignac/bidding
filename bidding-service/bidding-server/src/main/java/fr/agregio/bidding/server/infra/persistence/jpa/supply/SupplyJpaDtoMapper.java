package fr.agregio.bidding.server.infra.persistence.jpa.supply;

import fr.agregio.bidding.server.domain.bid.Supply;
import fr.agregio.bidding.server.domain.supplier.SupplierId;
import fr.agregio.bidding.server.infra.value.DefaultEnergyValueMapper;
import org.springframework.stereotype.Component;

@Component
class SupplyJpaDtoMapper {

    private final DefaultEnergyValueMapper energyValueMapper;
    private final SupplyIdGenerator supplyIdGenerator;

    SupplyJpaDtoMapper(
            DefaultEnergyValueMapper energyValueMapper,
            SupplyIdGenerator supplyIdGenerator) {
        this.energyValueMapper = energyValueMapper;
        this.supplyIdGenerator = supplyIdGenerator;
    }

    public Supply from(SupplyJpaDto dto) {
        var supplierId = new SupplierId(dto.getSupplierId());
        var energy = energyValueMapper.from(dto.getEnergy());
        return new Supply(
                supplierId,
                energy
        );
    }

    public SupplyJpaDto to(String bidBlockId, Supply supply) {
        var id = supplyIdGenerator.generate();
        var supplierId = supply.supplierId().value();
        var energy = energyValueMapper.to(supply.energy());
        return new SupplyJpaDto(
                id,
                bidBlockId,
                supplierId,
                energy
        );
    }

}
