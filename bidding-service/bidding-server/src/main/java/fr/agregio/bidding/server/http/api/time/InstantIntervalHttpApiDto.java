package fr.agregio.bidding.server.http.api.time;

import java.time.Instant;

public record InstantIntervalHttpApiDto(
        Instant start,
        Instant end) {

}
