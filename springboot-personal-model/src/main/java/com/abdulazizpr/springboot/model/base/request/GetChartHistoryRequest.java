package com.abdulazizpr.springboot.model.base.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetChartHistoryRequest {
    @NotBlank
    @Size(min = 1, max = 10)
    private String symbol;

    @NotNull
    private LocalDateTime from;

    @NotNull
    private LocalDateTime to;
}
