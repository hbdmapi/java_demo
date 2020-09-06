package com.huobi.common.entity;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jiapf
 */
@Data
public class FundingRate {
    private String symbol;

    @JSONField(name = "contract_code")
    private String contractCode;
    @JSONField(name = "funding_rate")
    private String fundingRate;
    @JSONField(name = "funding_time")
    private String fundingTime;
    @JSONField(name = "realized_rate")
    private String realizedRate;

}
