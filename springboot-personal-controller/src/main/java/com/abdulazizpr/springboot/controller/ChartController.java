package com.abdulazizpr.springboot.controller;

import com.abdulazizpr.springboot.command.CommandExecutor;
import com.abdulazizpr.springboot.command.chart.GetChartHistoryCommand;
import com.abdulazizpr.springboot.command.model.request.GetChartHistoryCommandRequest;
import com.abdulazizpr.springboot.entity.chart.ChartTick;
import com.abdulazizpr.springboot.model.base.request.GetChartHistoryRequest;
import com.abdulazizpr.springboot.model.base.response.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@Tag(name = "Chart")
@RestController
@RequestMapping("/api/v1/chart")
public class ChartController {

    @Autowired
    private CommandExecutor commandExecutor;

    @PostMapping(
            value = "/chart-history",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<BaseResponse<List<ChartTick>>> getChartHistory(
            @RequestBody() @Valid GetChartHistoryRequest request) {
        GetChartHistoryCommandRequest commandRequest = new GetChartHistoryCommandRequest(
                request.getSymbol(),
                request.getFrom(),
                request.getTo());

        return commandExecutor.execute(GetChartHistoryCommand.class, commandRequest);
    }
}
