package com.abdulazizpr.springboot.command.model.request;

import com.abdulazizpr.springboot.command.model.CommandRequest;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GetChartHistoryCommandRequest implements CommandRequest {
    @NotBlank
    @Size(min = 1, max = 10)
    private String symbol;

    @NotNull
    private LocalDateTime from;

    @NotNull
    private LocalDateTime to;
}