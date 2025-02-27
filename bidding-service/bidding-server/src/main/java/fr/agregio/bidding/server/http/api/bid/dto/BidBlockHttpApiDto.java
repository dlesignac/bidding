package fr.agregio.bidding.server.http.api.bid.dto;

import fr.agregio.bidding.server.http.api.time.InstantIntervalHttpApiDto;

import java.math.BigDecimal;
import java.util.List;

public record BidBlockHttpApiDto(
        InstantIntervalHttpApiDto instantInterval,
        BigDecimal price,
        List<SupplyHttpApiDto> supplies) {

}
