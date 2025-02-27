package fr.agregio.bidding.server.test.data;

import fr.agregio.bidding.server.domain.bid.Supply;
import fr.agregio.bidding.server.http.api.bid.dto.SupplyHttpApiDto;
import fr.agregio.bidding.server.tool.UtilityClass;

import static fr.agregio.bidding.server.test.data.TestEnergy.ENERGY_1;
import static fr.agregio.bidding.server.test.data.TestEnergy.ENERGY_1_VALUE;
import static fr.agregio.bidding.server.test.data.TestSupplier.SUPPLIER_1_ID;
import static fr.agregio.bidding.server.test.data.TestSupplier.SUPPLIER_1_ID_VALUE;

public final class TestSupply extends UtilityClass {

    public static final Supply SUPPLY_1 =
            new Supply(
                    SUPPLIER_1_ID,
                    ENERGY_1
            );

    public static final SupplyHttpApiDto SUPPLY_1_HTTP_API_DTO =
            new SupplyHttpApiDto(
                    SUPPLIER_1_ID_VALUE,
                    ENERGY_1_VALUE
            );

}
