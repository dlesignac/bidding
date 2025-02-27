package fr.agregio.bidding.server.http.api.bid.dto;

import java.util.List;

public record BidCreationRequestHttpApiDto(
        List<BidBlockHttpApiDto> blocks) {

}
