package com.abdulazizpr.springboot.migration.runner;

import com.abdulazizpr.springboot.entity.chart.ChartTick;
import com.abdulazizpr.springboot.repository.ChartTickRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class ChartTickDataRunner implements CommandLineRunner {
    private static final String SYMBOL = "AAPL";
    private static final Random random = new Random();
    private static final String LOG_MESSAGE_SAVING_CHART_TICK = "Saving chart tick: {}";
    private static final String LOG_MESSAGE_SAVING_SUCCESS = "Chart ticks data has been saved successfully";

    private final ChartTickRepository chartTickRepository;

    private final ApplicationContext applicationContext;

    @Override
    public void run(String... args) {
        List<ChartTick> chartTicks = generateChartTicksForLast7Days();
        saveChartTicks(chartTicks)
                .doOnNext(chartTick -> log.info(LOG_MESSAGE_SAVING_CHART_TICK, chartTick))
                .doOnComplete(() -> {
                    log.info(LOG_MESSAGE_SAVING_SUCCESS);
                    SpringApplication.exit(applicationContext);
                })
                .subscribe();
    }

    private List<ChartTick> generateChartTicksForLast7Days() {
        List<ChartTick> chartTicks = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            LocalDate date = LocalDate.now().minusDays(i);
            ChartTick chartTick = new ChartTick(
                    UUID.randomUUID(),
                    SYMBOL,
                    Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                    randomBigDecimal(),
                    randomBigDecimal(),
                    randomBigDecimal(),
                    randomBigDecimal(),
                    randomBigInteger(1000, 10000),
                    1,
                    randomBigInteger(100, 1000)
            );
            chartTicks.add(chartTick);
        }
        return chartTicks;
    }

    private BigDecimal randomBigDecimal() {
        return BigDecimal.valueOf(100 + (200 - 100) * random.nextDouble());
    }

    private BigInteger randomBigInteger(int min, int max) {
        return BigInteger.valueOf(min + random.nextInt(max - min));
    }

    private Flux<ChartTick> saveChartTicks(List<ChartTick> chartTicks) {
        return chartTickRepository.saveAll(chartTicks);
    }
}