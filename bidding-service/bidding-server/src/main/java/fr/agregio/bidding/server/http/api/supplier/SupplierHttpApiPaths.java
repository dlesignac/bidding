package fr.agregio.bidding.server.http.api.supplier;

import fr.agregio.bidding.server.tool.UtilityClass;

import static fr.agregio.bidding.server.http.api.market.MarketHttpApiPaths.MARKET_PATH;

public final class SupplierHttpApiPaths extends UtilityClass {

    public static final String SUPPLIERS_PATH = "/suppliers";

    public static final String MARKET_SUPPLIERS_PATH = MARKET_PATH + SUPPLIERS_PATH;

}
