package fr.agregio.bidding.server.test;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.context.jdbc.SqlMergeMode.MergeMode.MERGE;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("test")
@SqlMergeMode(MERGE)
@Sql("/sql/clean.sql")
public abstract class SpringContextAware {

    @Value("http://localhost:${local.server.port}${server.servlet.context-path}")
    private String baseUrl;

    @BeforeEach
    void setUpBaseUrl() {
        RestAssured.baseURI = baseUrl;
    }

}
