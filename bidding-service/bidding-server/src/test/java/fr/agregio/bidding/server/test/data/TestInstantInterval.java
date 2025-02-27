package fr.agregio.bidding.server.test.data;

import fr.agregio.bidding.server.http.api.time.InstantIntervalHttpApiDto;
import fr.agregio.bidding.server.tool.UtilityClass;
import org.threeten.extra.Interval;

import static fr.agregio.bidding.server.test.data.TestInstant.INSTANT_1;
import static fr.agregio.bidding.server.test.data.TestInstant.INSTANT_2;

public final class TestInstantInterval extends UtilityClass {

    public static final Interval INSTANT_INTERVAL_1 =
            Interval.of(
                    INSTANT_1,
                    INSTANT_2
            );

    public static final InstantIntervalHttpApiDto INSTANT_INTERVAL_1_HTTP_API_DTO =
            new InstantIntervalHttpApiDto(
                    INSTANT_1,
                    INSTANT_2
            );

}
