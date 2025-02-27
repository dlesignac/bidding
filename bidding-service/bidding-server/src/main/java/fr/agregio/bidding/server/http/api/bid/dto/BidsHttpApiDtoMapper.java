package fr.agregio.bidding.server.http.api.bid.dto;

import fr.agregio.bidding.server.domain.bid.Bid;
import fr.agregio.bidding.server.tool.OneWayMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BidsHttpApiDtoMapper
        implements OneWayMapper<List<Bid>, BidsHttpApiDto> {

    private final BidHttpApiDtoMapper bidHttpApiDtoMapper;

    BidsHttpApiDtoMapper(BidHttpApiDtoMapper bidHttpApiDtoMapper) {
        this.bidHttpApiDtoMapper = bidHttpApiDtoMapper;
    }

    @Override
    public BidsHttpApiDto map(List<Bid> bids) {
        var items = bidHttpApiDtoMapper.mapAll(bids);
        return new BidsHttpApiDto(items);
    }

}
