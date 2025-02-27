package fr.agregio.bidding.server.domain.energy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class EnergyTest {

    @Nested
    class Instantiation {

        @Test
        void value_can_not_be_null() {
            assertThatNullPointerException()
                    .isThrownBy(() -> new Energy(null, EnergyUnit.MEGA_WATT))
                    .withMessage("value can not be null");
        }

        @Test
        void unit_can_not_be_null() {
            assertThatNullPointerException()
                    .isThrownBy(() -> new Energy(BigDecimal.ONE, null))
                    .withMessage("unit can not be null");
        }

        @Test
        void value_must_be_greater_than_or_equal_to_0() {
            var negativeValue = BigDecimal.valueOf(-1);
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Energy(negativeValue, EnergyUnit.MEGA_WATT))
                    .withMessage("value must be greater than or equal to 0");
        }

    }

}
