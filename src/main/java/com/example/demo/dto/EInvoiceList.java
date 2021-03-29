package com.example.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/3/27 15:23
 */
@Data
public class EInvoiceList {
    @ApiModelProperty(value = "电子票据代码")
    private String eInvoiceCode;
    @ApiModelProperty(value = "电子票据号码")
    private String eInvoiceNumber;
    @ApiModelProperty(value = "电子票据校验码")
    private String randomNumber;
}
