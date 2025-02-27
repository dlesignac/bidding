package fr.agregio.bidding.server.http.api.supplier;

import fr.agregio.bidding.server.http.api.supplier.dto.MarketSuppliersHttpApiDto;
import fr.agregio.bidding.server.test.SpringContextAware;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import static fr.agregio.bidding.server.http.api.market.MarketHttpApiPaths.MARKET_ID;
import static fr.agregio.bidding.server.http.api.supplier.SupplierHttpApiPaths.MARKET_SUPPLIERS_PATH;
import static fr.agregio.bidding.server.test.data.TestMarket.MARKET_1_ID_VALUE;
import static fr.agregio.bidding.server.test.data.TestMarketSuppliers.MARKET_SUPPLIERS_1_HTTP_API_DTO;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

class FindAllMarketSuppliersTest extends SpringContextAware {

    @Test
    @Sql("/sql/insert_bid_1.sql")
    void it_returns_the_expected_response() {
        get_market_1_suppliers_and_check_response();
    }

    @Test
    @Sql({"/sql/insert_bid_1.sql", "/sql/insert_bid_2.sql"})
    void it_does_not_include_suppliers_of_other_markets() {
        get_market_1_suppliers_and_check_response();
    }

    @Test
    @Sql({"/sql/insert_bid_1.sql", "/sql/insert_bid_3.sql"})
    void it_does_not_duplicate_supplier_ids() {
        get_market_1_suppliers_and_check_response();
    }

    private void get_market_1_suppliers_and_check_response() {
        var response = given()
                .with().accept(APPLICATION_JSON_VALUE)
                .pathParam(MARKET_ID, MARKET_1_ID_VALUE)
                .get(MARKET_SUPPLIERS_PATH)
                .then()
                .statusCode(OK.value())
                .extract()
                .as(MarketSuppliersHttpApiDto.class);

        assertThat(response).isEqualTo(MARKET_SUPPLIERS_1_HTTP_API_DTO);
    }

}
