package fr.agregio.bidding.server.http.api.bid.dto;

import java.math.BigDecimal;

public record SupplyHttpApiDto(
        String supplierId,
        BigDecimal energy) {

}
