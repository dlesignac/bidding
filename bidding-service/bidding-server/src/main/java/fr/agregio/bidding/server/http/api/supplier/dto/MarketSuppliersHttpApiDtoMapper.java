package fr.agregio.bidding.server.http.api.supplier.dto;

import fr.agregio.bidding.server.domain.supplier.SupplierId;
import fr.agregio.bidding.server.tool.OneWayMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarketSuppliersHttpApiDtoMapper
        implements OneWayMapper<List<SupplierId>, MarketSuppliersHttpApiDto> {

    @Override
    public MarketSuppliersHttpApiDto map(List<SupplierId> supplierIds) {
        var items = supplierIds.stream()
                .map(SupplierId::value)
                .sorted()
                .toList();
        return new MarketSuppliersHttpApiDto(items);
    }

}
