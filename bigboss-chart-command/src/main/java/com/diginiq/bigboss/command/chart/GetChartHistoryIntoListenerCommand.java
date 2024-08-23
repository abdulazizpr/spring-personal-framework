package com.diginiq.bigboss.command.chart;

import com.diginiq.bigboss.command.model.request.GetChartHistoryCommandRequest;
import com.diginiq.bigboss.model.base.BaseResponse;
import com.diginiq.bigboss.utils.command.Command;
import reactor.core.publisher.Mono;

public interface GetChartHistoryIntoListenerCommand extends Command<Mono<BaseResponse>, GetChartHistoryCommandRequest> {
}
