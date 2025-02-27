package fr.agregio.bidding.server.http.api.bid;

import fr.agregio.bidding.server.domain.bid.BidService;
import fr.agregio.bidding.server.domain.market.MarketId;
import fr.agregio.bidding.server.http.api.bid.dto.*;
import org.springframework.web.bind.annotation.*;

import static fr.agregio.bidding.server.http.api.bid.BidHttpApiPaths.MARKET_BIDS_PATH;
import static fr.agregio.bidding.server.http.api.market.MarketHttpApiPaths.MARKET_ID;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(MARKET_BIDS_PATH)
class MarketBidsController {

    private final BidCreationRequestHttpApiDtoMapper bidCreationRequestHttpApiDtoMapper;
    private final BidHttpApiDtoMapper bidHttpApiDtoMapper;
    private final BidService bidService;
    private final BidsHttpApiDtoMapper bidsHttpApiDtoMapper;

    MarketBidsController(
            BidCreationRequestHttpApiDtoMapper bidCreationRequestHttpApiDtoMapper,
            BidHttpApiDtoMapper bidHttpApiDtoMapper,
            BidService bidService,
            BidsHttpApiDtoMapper bidsHttpApiDtoMapper) {
        this.bidCreationRequestHttpApiDtoMapper = bidCreationRequestHttpApiDtoMapper;
        this.bidHttpApiDtoMapper = bidHttpApiDtoMapper;
        this.bidService = bidService;
        this.bidsHttpApiDtoMapper = bidsHttpApiDtoMapper;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    BidsHttpApiDto findAll(@PathVariable(MARKET_ID) MarketId marketId) {
        var bids = bidService.findAll(marketId);
        return bidsHttpApiDtoMapper.map(bids);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    BidHttpApiDto create(
            @PathVariable(MARKET_ID) MarketId marketId,
            @RequestBody BidCreationRequestHttpApiDto requestDto) {
        // todo: validate request
        var request = bidCreationRequestHttpApiDtoMapper.map(requestDto);
        var created = bidService.create(marketId, request);
        return bidHttpApiDtoMapper.map(created);
    }

}
