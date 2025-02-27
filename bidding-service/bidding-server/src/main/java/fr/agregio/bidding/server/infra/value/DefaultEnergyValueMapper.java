package fr.agregio.bidding.server.infra.value;

import fr.agregio.bidding.server.domain.energy.Energy;
import fr.agregio.bidding.server.tool.TwoWayMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DefaultEnergyValueMapper
        implements TwoWayMapper<Energy, BigDecimal> {

    @Override
    public Energy from(BigDecimal value) {
        return Energy.ofMegaWatts(value);
    }

    @Override
    public BigDecimal to(Energy energy) {
        return energy.toMegaWatts().value();
    }

}
