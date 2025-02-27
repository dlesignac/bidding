package fr.agregio.bidding.server.test.data;

import fr.agregio.bidding.server.domain.energy.Energy;
import fr.agregio.bidding.server.tool.UtilityClass;

import java.math.BigDecimal;

public final class TestEnergy extends UtilityClass {

    public static final BigDecimal ENERGY_1_VALUE = BigDecimal.ONE;
    public static final Energy ENERGY_1 = Energy.ofMegaWatts(ENERGY_1_VALUE);

}
