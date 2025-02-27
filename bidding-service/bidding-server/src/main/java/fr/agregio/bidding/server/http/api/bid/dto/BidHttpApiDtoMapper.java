package fr.agregio.bidding.server.http.api.bid.dto;

import fr.agregio.bidding.server.domain.bid.Bid;
import fr.agregio.bidding.server.tool.OneWayMapper;
import org.springframework.stereotype.Component;

@Component
public class BidHttpApiDtoMapper
        implements OneWayMapper<Bid, BidHttpApiDto> {

    private final BidBlockHttpApiDtoMapper bidBlockHttpApiDtoMapper;

    BidHttpApiDtoMapper(BidBlockHttpApiDtoMapper bidBlockHttpApiDtoMapper) {
        this.bidBlockHttpApiDtoMapper = bidBlockHttpApiDtoMapper;
    }

    @Override
    public BidHttpApiDto map(Bid bid) {
        var marketId = bid.marketId().value();
        var blocks = bidBlockHttpApiDtoMapper.toAll(bid.blocks());
        return new BidHttpApiDto(marketId, blocks);
    }

}
