package fr.agregio.bidding.server.infra.persistence.jpa.bid;

import fr.agregio.bidding.server.domain.bid.BidBlock;
import fr.agregio.bidding.server.domain.bid.Supply;
import fr.agregio.bidding.server.infra.persistence.jpa.time.InstantIntervalJpaDtoMapper;
import fr.agregio.bidding.server.infra.value.DefaultEnergyPriceValueMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class BidBlockJpaDtoMapper {

    private final BidBlockIdGenerator bidBlockIdGenerator;
    private final DefaultEnergyPriceValueMapper energyPriceValueMapper;
    private final InstantIntervalJpaDtoMapper instantIntervalJpaDtoMapper;

    BidBlockJpaDtoMapper(
            BidBlockIdGenerator bidBlockIdGenerator,
            DefaultEnergyPriceValueMapper energyPriceValueMapper,
            InstantIntervalJpaDtoMapper instantIntervalJpaDtoMapper) {
        this.bidBlockIdGenerator = bidBlockIdGenerator;
        this.energyPriceValueMapper = energyPriceValueMapper;
        this.instantIntervalJpaDtoMapper = instantIntervalJpaDtoMapper;
    }

    public BidBlock from(BidBlockJpaDto dto, List<Supply> supplies) {
        var instantInterval = instantIntervalJpaDtoMapper.from(dto.getInstantInterval());
        var price = energyPriceValueMapper.from(dto.getPrice());
        return new BidBlock(
                instantInterval,
                price,
                supplies
        );
    }

    public BidBlockJpaDto to(String bidId, BidBlock bidBlock) {
        var id = bidBlockIdGenerator.generate();
        var instantInterval = instantIntervalJpaDtoMapper.to(bidBlock.instantInterval());
        var price = energyPriceValueMapper.to(bidBlock.price());
        return new BidBlockJpaDto(
                id,
                bidId,
                instantInterval,
                price
        );
    }

}
