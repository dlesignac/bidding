package fr.agregio.bidding.server.domain.energy;

import java.math.BigDecimal;
import java.util.Objects;

public record EnergyPrice(
        BigDecimal value,
        EnergyPriceUnit unit) {

    public static EnergyPrice ofCurrencyPerMegaWatt(BigDecimal value) {
        return new EnergyPrice(value, EnergyPriceUnit.CURRENCY_PER_MEGA_WATT);
    }

    public EnergyPrice {
        Objects.requireNonNull(value);
        Objects.requireNonNull(unit);

        if (value.signum() < 0) {
            throw new IllegalArgumentException("Energy value must be greater than or equal to 0");
        }
    }

    public EnergyPrice toCurrencyPerMegaWatt() {
        return this;
    }

}
