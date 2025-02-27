package fr.agregio.bidding.server.http.api.time;

import org.springframework.stereotype.Component;
import org.threeten.extra.Interval;

@Component
public class InstantIntervalHttpApiDtoMapper {

    public Interval from(InstantIntervalHttpApiDto dto) {
        return Interval.of(dto.start(), dto.end());
    }

    public InstantIntervalHttpApiDto to(Interval interval) {
        return new InstantIntervalHttpApiDto(interval.getStart(), interval.getEnd());
    }

}
