package com.abdulazizpr.springboot.integration.chart;

import com.abdulazizpr.springboot.application.SpringBootPersonalApplication;
import com.abdulazizpr.springboot.entity.chart.ChartTick;
import com.abdulazizpr.springboot.helper.TestHelper;
import com.abdulazizpr.springboot.model.base.request.GetChartHistoryRequest;
import com.abdulazizpr.springboot.repository.ChartTickRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest(
        classes = SpringBootPersonalApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {"spring.config.name=application-test"}
)
@AutoConfigureWebTestClient
public class GetChartHistoryTest {

    private static final String SYMBOL = "AAPL";
    private static final String API_V1_CHART_CHART_HISTORY = "/api/v1/chart/chart-history";

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ChartTickRepository repository;

    @BeforeEach
    public void setUp() throws IOException {
        //delete all data
        repository.deleteAll().block();

        List<ChartTick> chartTicks = TestHelper.readJsonArray(
                "api/database/chart-tick/chart-tick.json",
                ChartTick.class
        );

        repository.saveAll(chartTicks)
                .subscribe();
    }

    @Test
    public void test_get_chart_history_success_200_with_data() throws IOException {
        String expectedResponse = TestHelper
                .readJsonContent("api/spec/chart/chart-history-response-200.json");

       webTestClient.post()
                .uri(API_V1_CHART_CHART_HISTORY)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(createRequestForChartHistory1()), GetChartHistoryRequest.class)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .json(expectedResponse);
    }

    private GetChartHistoryRequest createRequestForChartHistory1() {
        GetChartHistoryRequest request = new GetChartHistoryRequest();
        request.setSymbol(SYMBOL);
        request.setFrom(LocalDateTime.parse("2024-08-19T00:00:00"));
        request.setTo(LocalDateTime.parse("2024-08-24T00:00:00"));
        return request;
    }
}