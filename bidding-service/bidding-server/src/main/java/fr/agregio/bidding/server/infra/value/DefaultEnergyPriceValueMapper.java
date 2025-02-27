package fr.agregio.bidding.server.infra.value;

import fr.agregio.bidding.server.domain.energy.EnergyPrice;
import fr.agregio.bidding.server.tool.TwoWayMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DefaultEnergyPriceValueMapper
        implements TwoWayMapper<EnergyPrice, BigDecimal> {

    @Override
    public EnergyPrice from(BigDecimal value) {
        return EnergyPrice.ofCurrencyPerMegaWatt(value);
    }

    @Override
    public BigDecimal to(EnergyPrice price) {
        return price.toCurrencyPerMegaWatt().value();
    }

}
