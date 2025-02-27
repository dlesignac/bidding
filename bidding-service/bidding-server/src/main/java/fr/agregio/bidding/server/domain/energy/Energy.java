package fr.agregio.bidding.server.domain.energy;

import java.math.BigDecimal;
import java.util.Objects;

public record Energy(
        BigDecimal value,
        EnergyUnit unit) {

    public static Energy ofMegaWatts(BigDecimal value) {
        return new Energy(value, EnergyUnit.MEGA_WATT);
    }

    public Energy {
        Objects.requireNonNull(value, "value can not be null");
        Objects.requireNonNull(unit, "unit can not be null");

        if (value.signum() < 0) {
            throw new IllegalArgumentException("value must be greater than or equal to 0");
        }
    }

    public Energy toMegaWatts() {
        return this;
    }

}
