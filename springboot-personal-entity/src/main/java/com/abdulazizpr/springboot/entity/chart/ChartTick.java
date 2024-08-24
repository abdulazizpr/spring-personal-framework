package com.abdulazizpr.springboot.entity.chart;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chart_tick", indexes = {
        @Index(name = "idx_symbol", columnList = "symbol"),
        @Index(name = "idx_dateTime", columnList = "date_time")
})
public class ChartTick {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID")
    private UUID id;

    @Column(name = "symbol", nullable = false)
    private String symbol;

    @Column(name = "date_time", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

    @Column(name = "open", precision = 19, scale = 4, columnDefinition = "NUMERIC")
    private BigDecimal open;

    @Column(name = "high", precision = 19, scale = 4, columnDefinition = "NUMERIC")
    private BigDecimal high;

    @Column(name = "low", precision = 19, scale = 4, columnDefinition = "NUMERIC")
    private BigDecimal low;

    @Column(name = "close", precision = 19, scale = 4, columnDefinition = "NUMERIC")
    private BigDecimal close;

    @Column(name = "tick_volume", columnDefinition = "NUMERIC")
    private BigInteger tickVolume;

    @Column(name = "spread", columnDefinition = "INTEGER")
    private int spread;

    @Column(name = "volume", columnDefinition = "NUMERIC")
    private BigInteger volume;
}
