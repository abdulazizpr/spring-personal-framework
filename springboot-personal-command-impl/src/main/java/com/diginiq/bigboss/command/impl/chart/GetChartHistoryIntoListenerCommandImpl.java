package com.diginiq.bigboss.command.impl.chart;

import com.diginiq.bigboss.command.chart.GetChartHistoryIntoListenerCommand;
import com.diginiq.bigboss.command.model.request.GetChartHistoryCommandRequest;
import com.diginiq.bigboss.model.base.BaseResponse;
import com.diginiq.bigboss.utils.helper.BaseResponseHelper;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.Service;

@Service
public class GetChartHistoryIntoListenerCommandImpl implements GetChartHistoryIntoListenerCommand {

    @Override
    public Mono<BaseResponse> execute(GetChartHistoryCommandRequest request) {
        return Mono.fromCallable(() -> {
            try {
                // Fetch chart data using the helper method
                Object chartData = fetchChartData(request);

                // Create success response with data
                return BaseResponseHelper.successWithData(chartData);
            } catch (Exception e) {
                // Create error response
                return BaseResponseHelper.badRequestEmptyData();
            }
        });
    }

    private Object fetchChartData(GetChartHistoryCommandRequest request) {
        // Implement your data fetching logic here
        return new Object(); // Replace with actual data
    }
}
