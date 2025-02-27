package fr.agregio.bidding.server.http.api.bid;

import fr.agregio.bidding.server.http.api.bid.dto.BidsHttpApiDto;
import fr.agregio.bidding.server.test.SpringContextAware;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import static fr.agregio.bidding.server.http.api.bid.BidHttpApiPaths.MARKET_BIDS_PATH;
import static fr.agregio.bidding.server.http.api.market.MarketHttpApiPaths.MARKET_ID;
import static fr.agregio.bidding.server.test.data.TestBid.BIDS_1_HTTP_API_DTO;
import static fr.agregio.bidding.server.test.data.TestMarket.MARKET_1_ID_VALUE;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

class FindAllMarketBidsTest extends SpringContextAware {

    @Test
    @Sql({"/sql/insert_bid_1.sql", "/sql/insert_bid_2.sql"})
    void it_returns_the_expected_response() {
        var response = given()
                .with().accept(APPLICATION_JSON_VALUE)
                .pathParam(MARKET_ID, MARKET_1_ID_VALUE)
                .get(MARKET_BIDS_PATH)
                .then()
                .statusCode(OK.value())
                .extract()
                .as(BidsHttpApiDto.class);

        assertThat(response).isEqualTo(BIDS_1_HTTP_API_DTO);
    }

}
