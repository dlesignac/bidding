package fr.agregio.bidding.server.http.api.bid;

import fr.agregio.bidding.server.domain.bid.BidRepository;
import fr.agregio.bidding.server.http.api.bid.dto.BidHttpApiDto;
import fr.agregio.bidding.server.test.SpringContextAware;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static fr.agregio.bidding.server.http.api.bid.BidHttpApiPaths.MARKET_BIDS_PATH;
import static fr.agregio.bidding.server.http.api.market.MarketHttpApiPaths.MARKET_ID;
import static fr.agregio.bidding.server.test.data.TestBid.BID_1;
import static fr.agregio.bidding.server.test.data.TestBid.BID_1_HTTP_API_DTO;
import static fr.agregio.bidding.server.test.data.TestBidCreationRequest.BID_CREATION_REQUEST_1_HTTP_API_DTO;
import static fr.agregio.bidding.server.test.data.TestMarket.MARKET_1_ID_VALUE;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

class CreateMarketBidTest extends SpringContextAware {

    private @Autowired BidRepository bidRepository;

    @Test
    void it_persists_and_returns_the_expected_response() {
        var response = given()
                .with().contentType(APPLICATION_JSON_VALUE)
                .body(BID_CREATION_REQUEST_1_HTTP_API_DTO)
                .pathParam(MARKET_ID, MARKET_1_ID_VALUE)
                .post(MARKET_BIDS_PATH)
                .then()
                .statusCode(OK.value())
                .extract()
                .as(BidHttpApiDto.class);

        assertThat(response).isEqualTo(BID_1_HTTP_API_DTO);

        var saved = bidRepository.findAll();
        assertThat(saved).containsExactly(BID_1);
    }

}
