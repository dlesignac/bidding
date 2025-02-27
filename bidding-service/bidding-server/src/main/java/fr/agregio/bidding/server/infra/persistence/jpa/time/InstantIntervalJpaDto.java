package fr.agregio.bidding.server.infra.persistence.jpa.time;

import jakarta.persistence.Embeddable;

import java.time.Instant;

@Embeddable
public class InstantIntervalJpaDto {

    private Instant start;
    private Instant end;

    public InstantIntervalJpaDto() {

    }

    InstantIntervalJpaDto(
            Instant start,
            Instant end) {
        this.start = start;
        this.end = end;
    }

    public Instant getStart() {
        return start;
    }

    public void setStart(Instant start) {
        this.start = start;
    }

    public Instant getEnd() {
        return end;
    }

    public void setEnd(Instant end) {
        this.end = end;
    }

}
