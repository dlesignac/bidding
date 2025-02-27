package fr.agregio.bidding.server.test.data;

import fr.agregio.bidding.server.domain.bid.BidBlock;
import fr.agregio.bidding.server.http.api.bid.dto.BidBlockHttpApiDto;
import fr.agregio.bidding.server.tool.UtilityClass;

import java.util.List;

import static fr.agregio.bidding.server.test.data.TestEnergyPrice.ENERGY_PRICE_1;
import static fr.agregio.bidding.server.test.data.TestEnergyPrice.ENERGY_PRICE_1_VALUE;
import static fr.agregio.bidding.server.test.data.TestInstantInterval.INSTANT_INTERVAL_1;
import static fr.agregio.bidding.server.test.data.TestInstantInterval.INSTANT_INTERVAL_1_HTTP_API_DTO;
import static fr.agregio.bidding.server.test.data.TestSupply.SUPPLY_1;
import static fr.agregio.bidding.server.test.data.TestSupply.SUPPLY_1_HTTP_API_DTO;

public final class TestBidBlock extends UtilityClass {

    public static final BidBlock BID_BLOCK_1 =
            new BidBlock(
                    INSTANT_INTERVAL_1,
                    ENERGY_PRICE_1,
                    List.of(SUPPLY_1)
            );

    public static final BidBlockHttpApiDto BID_BLOCK_1_HTTP_API_DTO =
            new BidBlockHttpApiDto(
                    INSTANT_INTERVAL_1_HTTP_API_DTO,
                    ENERGY_PRICE_1_VALUE,
                    List.of(SUPPLY_1_HTTP_API_DTO)
            );

}
