package com.diginiq.bigboss.model.request.websocket;

import com.diginiq.bigboss.model.request.base.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GetChartHistoryRequestDto extends BaseRequest {
    private String symbol;
    private Date fromDate;
    private Date toDate;
}
