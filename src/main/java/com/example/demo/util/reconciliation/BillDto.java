package com.example.demo.util.reconciliation;

import com.example.demo.elsfk.fk.S;
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

    public String getString(){
        StringBuffer sb = new StringBuffer();
        sb.append(this.invoicingPartyCode).append("||")
                .append(this.invoicingPartyCode).append("||")
                .append(this.invoicingPartyName).append("||")
                .append(this.einvoiceType).append("||")
                .append(this.einvoiceCode).append("||")
                .append(this.einvoiceNumber).append("||")
                .append(this.randomNumber).append("||")
                .append(this.date).append("||")
                .append("1").append("||")
                .append("对账票据不存在").append("||");
        return  sb.toString();
    }
}
