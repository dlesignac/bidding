package fr.agregio.bidding.server.test.data;

import fr.agregio.bidding.server.domain.energy.EnergyPrice;
import fr.agregio.bidding.server.tool.UtilityClass;

import java.math.BigDecimal;

public final class TestEnergyPrice extends UtilityClass {

    public static final BigDecimal ENERGY_PRICE_1_VALUE = BigDecimal.ONE;
    public static final EnergyPrice ENERGY_PRICE_1 = EnergyPrice.ofCurrencyPerMegaWatt(ENERGY_PRICE_1_VALUE);

}
