package com.example.demo.util.reconciliation;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/6/24 15:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDto implements Serializable {

    private String invoicingPartyCode;
    private String invoicingPartyName;
    private Integer einvoiceType;
    private String einvoiceCode;
    private String einvoiceNumber;
    private String randomNumber;
    private String date;
    private String areaCode;
    private String standardUnitCode;
    private String standardUnitName;

    @Override
    public String toString() {
        return "BillDto{" +
                "invoicingPartyCode='" + invoicingPartyCode + '\'' +
                ", invoicingPartyName='" + invoicingPartyName + '\'' +
                ", einvoiceType=" + einvoiceType +
                ", einvoiceCode='" + einvoiceCode + '\'' +
                ", einvoiceNumber='" + einvoiceNumber + '\'' +
                ", randomNumber='" + randomNumber + '\'' +
                ", date='" + date + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", standardUnitCode='" + standardUnitCode + '\'' +
                ", standardUnitName='" + standardUnitName + '\'' +
                '}';
    }
}
