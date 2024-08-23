package com.abdulazizpr.springboot.entity.chart;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chart_history", indexes = {
        @Index(name = "idx_symbol", columnList = "symbol")
})
public class ChartTick {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID")
    private UUID id;

    @Column(name = "symbol", nullable = false)
    private String symbol;

    @Column(name = "date_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

    @Column(name = "open", precision = 19, scale = 4)
    private BigDecimal open;

    @Column(name = "high", precision = 19, scale = 4)
    private BigDecimal high;

    @Column(name = "low", precision = 19, scale = 4)
    private BigDecimal low;

    @Column(name = "close", precision = 19, scale = 4)
    private BigDecimal close;

    @Column(name = "tick_volume")
    private BigInteger tickVolume;

    @Column(name = "spread")
    private int spread;

    @Column(name = "volume")
    private BigInteger volume;
}