package fr.agregio.bidding.server.test.data;

import fr.agregio.bidding.server.domain.bid.Bid;
import fr.agregio.bidding.server.http.api.bid.dto.BidHttpApiDto;
import fr.agregio.bidding.server.http.api.bid.dto.BidsHttpApiDto;
import fr.agregio.bidding.server.tool.UtilityClass;

import java.util.List;

import static fr.agregio.bidding.server.test.data.TestBidBlock.BID_BLOCK_1;
import static fr.agregio.bidding.server.test.data.TestBidBlock.BID_BLOCK_1_HTTP_API_DTO;
import static fr.agregio.bidding.server.test.data.TestMarket.MARKET_1_ID;
import static fr.agregio.bidding.server.test.data.TestMarket.MARKET_1_ID_VALUE;

public final class TestBid extends UtilityClass {

    public static final Bid BID_1 =
            new Bid(
                    MARKET_1_ID,
                    List.of(BID_BLOCK_1)
            );

    public static final BidHttpApiDto BID_1_HTTP_API_DTO =
            new BidHttpApiDto(
                    MARKET_1_ID_VALUE,
                    List.of(BID_BLOCK_1_HTTP_API_DTO)
            );

    public static final BidsHttpApiDto BIDS_1_HTTP_API_DTO =
            new BidsHttpApiDto(
                    List.of(BID_1_HTTP_API_DTO)
            );

}
