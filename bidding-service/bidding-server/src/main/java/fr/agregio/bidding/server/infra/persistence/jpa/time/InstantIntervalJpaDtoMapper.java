package fr.agregio.bidding.server.infra.persistence.jpa.time;

import fr.agregio.bidding.server.tool.TwoWayMapper;
import org.springframework.stereotype.Component;
import org.threeten.extra.Interval;

@Component
public class InstantIntervalJpaDtoMapper
        implements TwoWayMapper<Interval, InstantIntervalJpaDto> {

    @Override
    public Interval from(InstantIntervalJpaDto instantIntervalJpaDto) {
        return Interval.of(
                instantIntervalJpaDto.getStart(),
                instantIntervalJpaDto.getEnd()
        );
    }

    @Override
    public InstantIntervalJpaDto to(Interval interval) {
        return new InstantIntervalJpaDto(
                interval.getStart(),
                interval.getEnd()
        );
    }

}
