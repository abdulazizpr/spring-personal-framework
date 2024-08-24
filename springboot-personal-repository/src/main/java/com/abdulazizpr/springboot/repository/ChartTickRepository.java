package com.abdulazizpr.springboot.repository;

import com.abdulazizpr.springboot.entity.chart.ChartTick;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChartTickRepository extends R2dbcRepository<ChartTick, UUID> {
}
