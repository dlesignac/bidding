package fr.agregio.bidding.server.http.api.bid.dto;

import fr.agregio.bidding.server.domain.bid.BidCreationRequest;
import fr.agregio.bidding.server.tool.OneWayMapper;
import org.springframework.stereotype.Component;

@Component
public class BidCreationRequestHttpApiDtoMapper
        implements OneWayMapper<BidCreationRequestHttpApiDto, BidCreationRequest> {

    private final BidBlockHttpApiDtoMapper bidBlockHttpApiDtoMapper;

    BidCreationRequestHttpApiDtoMapper(BidBlockHttpApiDtoMapper bidBlockHttpApiDtoMapper) {
        this.bidBlockHttpApiDtoMapper = bidBlockHttpApiDtoMapper;
    }

    @Override
    public BidCreationRequest map(BidCreationRequestHttpApiDto dto) {
        var blocks = bidBlockHttpApiDtoMapper.fromAll(dto.blocks());
        return new BidCreationRequest(blocks);
    }

}
