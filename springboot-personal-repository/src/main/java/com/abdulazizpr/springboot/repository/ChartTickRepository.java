package com.abdulazizpr.springboot.repository;

import com.abdulazizpr.springboot.entity.chart.ChartTick;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChartTickRepository extends ReactiveCrudRepository<ChartTick, Long> {
}
