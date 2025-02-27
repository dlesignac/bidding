package fr.agregio.bidding.server.http.api.bid.dto;

import fr.agregio.bidding.server.domain.bid.BidBlock;
import fr.agregio.bidding.server.http.api.time.InstantIntervalHttpApiDtoMapper;
import fr.agregio.bidding.server.infra.value.DefaultEnergyPriceValueMapper;
import fr.agregio.bidding.server.tool.TwoWayMapper;
import org.springframework.stereotype.Component;

@Component
class BidBlockHttpApiDtoMapper
        implements TwoWayMapper<BidBlock, BidBlockHttpApiDto> {

    private final DefaultEnergyPriceValueMapper energyPriceValueMapper;
    private final InstantIntervalHttpApiDtoMapper instantIntervalHttpApiDtoMapper;
    private final SupplyHttpApiDtoMapper supplyHttpApiDtoMapper;

    BidBlockHttpApiDtoMapper(
            DefaultEnergyPriceValueMapper energyPriceValueMapper,
            InstantIntervalHttpApiDtoMapper instantIntervalHttpApiDtoMapper,
            SupplyHttpApiDtoMapper supplyHttpApiDtoMapper) {
        this.energyPriceValueMapper = energyPriceValueMapper;
        this.instantIntervalHttpApiDtoMapper = instantIntervalHttpApiDtoMapper;
        this.supplyHttpApiDtoMapper = supplyHttpApiDtoMapper;
    }

    @Override
    public BidBlock from(BidBlockHttpApiDto dto) {
        var instantInterval = instantIntervalHttpApiDtoMapper.from(dto.instantInterval());
        var price = energyPriceValueMapper.from(dto.price());
        var supplies = supplyHttpApiDtoMapper.fromAll(dto.supplies());
        return new BidBlock(
                instantInterval,
                price,
                supplies
        );
    }

    @Override
    public BidBlockHttpApiDto to(BidBlock bidBlock) {
        var instantInterval = instantIntervalHttpApiDtoMapper.to(bidBlock.instantInterval());
        var price = energyPriceValueMapper.to(bidBlock.price());
        var supplies = supplyHttpApiDtoMapper.toAll(bidBlock.supplies());
        return new BidBlockHttpApiDto(
                instantInterval,
                price,
                supplies
        );
    }

}
