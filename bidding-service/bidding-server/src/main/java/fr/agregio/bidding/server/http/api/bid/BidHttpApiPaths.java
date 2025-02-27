package fr.agregio.bidding.server.http.api.bid;

import fr.agregio.bidding.server.tool.UtilityClass;

import static fr.agregio.bidding.server.http.api.market.MarketHttpApiPaths.MARKET_PATH;

public final class BidHttpApiPaths extends UtilityClass {

    public static final String BIDS_PATH = "/bids";

    public static final String MARKET_BIDS_PATH = MARKET_PATH + BIDS_PATH;

}
