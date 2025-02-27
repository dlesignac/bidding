package fr.agregio.bidding.server.http.api.bid.dto;

import fr.agregio.bidding.server.domain.bid.Supply;
import fr.agregio.bidding.server.domain.supplier.SupplierId;
import fr.agregio.bidding.server.infra.value.DefaultEnergyValueMapper;
import fr.agregio.bidding.server.tool.TwoWayMapper;
import org.springframework.stereotype.Component;

@Component
class SupplyHttpApiDtoMapper
        implements TwoWayMapper<Supply, SupplyHttpApiDto> {

    private final DefaultEnergyValueMapper energyValueMapper;

    SupplyHttpApiDtoMapper(DefaultEnergyValueMapper energyValueMapper) {
        this.energyValueMapper = energyValueMapper;
    }

    @Override
    public Supply from(SupplyHttpApiDto dto) {
        var supplierId = new SupplierId(dto.supplierId());
        var energy = energyValueMapper.from(dto.energy());
        return new Supply(supplierId, energy);
    }

    @Override
    public SupplyHttpApiDto to(Supply supply) {
        var supplierId = supply.supplierId().value();
        var energy = energyValueMapper.to(supply.energy());
        return new SupplyHttpApiDto(supplierId, energy);
    }

}
