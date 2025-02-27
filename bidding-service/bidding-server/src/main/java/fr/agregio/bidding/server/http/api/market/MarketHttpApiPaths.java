package fr.agregio.bidding.server.http.api.market;

import fr.agregio.bidding.server.tool.UtilityClass;

public final class MarketHttpApiPaths extends UtilityClass {

    public static final String MARKETS_PATH = "/markets";
    public static final String MARKET_ID = "marketId";
    public static final String MARKET_ID_PATH = "/{" + MARKET_ID + '}';
    public static final String MARKET_PATH = MARKETS_PATH + MARKET_ID_PATH;

}
