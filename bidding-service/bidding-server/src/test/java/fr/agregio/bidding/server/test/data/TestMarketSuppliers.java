package fr.agregio.bidding.server.test.data;

import fr.agregio.bidding.server.http.api.supplier.dto.MarketSuppliersHttpApiDto;
import fr.agregio.bidding.server.tool.UtilityClass;

import java.util.List;

import static fr.agregio.bidding.server.test.data.TestSupplier.SUPPLIER_1_ID_VALUE;

public final class TestMarketSuppliers extends UtilityClass {

    public static final MarketSuppliersHttpApiDto MARKET_SUPPLIERS_1_HTTP_API_DTO =
            new MarketSuppliersHttpApiDto(
                    List.of(SUPPLIER_1_ID_VALUE)
            );

}
