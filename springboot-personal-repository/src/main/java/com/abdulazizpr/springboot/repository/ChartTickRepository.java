package com.abdulazizpr.springboot.repository;

import com.abdulazizpr.springboot.entity.chart.ChartTick;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface ChartTickRepository extends R2dbcRepository<ChartTick, UUID> {
    Flux<ChartTick> findChartTickBySymbolAndDateTimeBetween(String symbol,
                                                            LocalDateTime from,
                                                            LocalDateTime to);
}
