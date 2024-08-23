package com.diginiq.bigboss.command.model.request;

import com.diginiq.bigboss.utils.command.model.response.request.CommandRequest;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GetChartHistoryCommandRequest implements CommandRequest {
    @NotBlank
    @Size(min = 1, max = 10)
    private String symbol;

    @NotBlank
    @Size(min = 1, max = 10)
    private String timeframe;

    @Min(1000)
    @Max(2147483647)
    private long from;

    @Min(1000)
    @Max(2147483647)
    private long to;
}