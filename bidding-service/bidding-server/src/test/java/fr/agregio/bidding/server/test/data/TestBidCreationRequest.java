package fr.agregio.bidding.server.test.data;

import fr.agregio.bidding.server.http.api.bid.dto.BidCreationRequestHttpApiDto;
import fr.agregio.bidding.server.tool.UtilityClass;

import java.util.List;

import static fr.agregio.bidding.server.test.data.TestBidBlock.BID_BLOCK_1_HTTP_API_DTO;

public final class TestBidCreationRequest extends UtilityClass {

    public static final BidCreationRequestHttpApiDto BID_CREATION_REQUEST_1_HTTP_API_DTO =
            new BidCreationRequestHttpApiDto(
                    List.of(BID_BLOCK_1_HTTP_API_DTO)
            );

}
