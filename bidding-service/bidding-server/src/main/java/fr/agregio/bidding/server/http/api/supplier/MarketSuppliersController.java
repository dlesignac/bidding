package fr.agregio.bidding.server.http.api.supplier;

import fr.agregio.bidding.server.domain.market.MarketId;
import fr.agregio.bidding.server.domain.supplier.SupplierService;
import fr.agregio.bidding.server.http.api.supplier.dto.MarketSuppliersHttpApiDto;
import fr.agregio.bidding.server.http.api.supplier.dto.MarketSuppliersHttpApiDtoMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static fr.agregio.bidding.server.http.api.market.MarketHttpApiPaths.MARKET_ID;
import static fr.agregio.bidding.server.http.api.supplier.SupplierHttpApiPaths.MARKET_SUPPLIERS_PATH;

@RestController
@RequestMapping(MARKET_SUPPLIERS_PATH)
class MarketSuppliersController {

    private final MarketSuppliersHttpApiDtoMapper marketSuppliersHttpApiDtoMapper;
    private final SupplierService supplierService;

    MarketSuppliersController(
            MarketSuppliersHttpApiDtoMapper marketSuppliersHttpApiDtoMapper,
            SupplierService supplierService) {
        this.marketSuppliersHttpApiDtoMapper = marketSuppliersHttpApiDtoMapper;
        this.supplierService = supplierService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    MarketSuppliersHttpApiDto findAll(
            @PathVariable(MARKET_ID) MarketId marketId) {
        var supplierIds = supplierService.findAllIds(marketId);
        return marketSuppliersHttpApiDtoMapper.map(supplierIds);
    }

}
