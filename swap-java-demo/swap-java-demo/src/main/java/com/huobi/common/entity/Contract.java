package com.huobi.common.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author jiapf
 */
@Data
public class Contract {

    @JSONField(name = "contract_code")
    private String contractCode;
}
