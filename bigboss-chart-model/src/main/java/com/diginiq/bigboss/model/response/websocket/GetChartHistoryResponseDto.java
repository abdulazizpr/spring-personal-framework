package com.diginiq.bigboss.model.response.websocket;

import com.diginiq.bigboss.entity.chart.ChartHistory;
import com.diginiq.bigboss.model.response.base.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetChartHistoryResponseDto extends BaseResponse {
    List<ChartHistory> data;
}
