package com.abdulazizpr.springboot.command.chart;

import com.abdulazizpr.springboot.command.Command;
import com.abdulazizpr.springboot.command.model.request.GetChartHistoryCommandRequest;
import com.abdulazizpr.springboot.entity.chart.ChartTick;
import com.abdulazizpr.springboot.model.base.response.BaseResponse;

import java.util.List;

public interface GetChartHistoryCommand extends Command<BaseResponse<List<ChartTick>>, GetChartHistoryCommandRequest> {
}
