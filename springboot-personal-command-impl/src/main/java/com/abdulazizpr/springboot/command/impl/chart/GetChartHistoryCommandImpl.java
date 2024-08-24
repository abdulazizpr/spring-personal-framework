package com.abdulazizpr.springboot.command.impl.chart;

import com.abdulazizpr.springboot.command.chart.GetChartHistoryCommand;
import com.abdulazizpr.springboot.command.model.request.GetChartHistoryCommandRequest;
import com.abdulazizpr.springboot.entity.chart.ChartTick;
import com.abdulazizpr.springboot.helper.BaseResponseHelper;
import com.abdulazizpr.springboot.model.base.response.BaseResponse;
import com.abdulazizpr.springboot.repository.ChartTickRepository;
import com.abdulazizpr.springboot.utils.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetChartHistoryCommandImpl implements GetChartHistoryCommand {

    private final ChartTickRepository repository;

    @Override
    public Mono<BaseResponse<List<ChartTick>>> execute(GetChartHistoryCommandRequest request) {
        return repository.findChartTickBySymbolAndDateTimeBetween(request.getSymbol(),
                        request.getFrom(),
                        request.getTo())
                .collectList()
                .map(BaseResponseHelper::success);
    }
}
