package com.example.demo.common.test;

import java.util.Date;
import lombok.Data;

/**
 * 描述：地方上传单位号码赋码
 *
 * @author yinjiaqi
 * @date 2021/7/26 16:07
 */
@Data
public class PlaceUploadMedicalCodeDto {
    private String regiCode;
    private String enterGuid;
    private String bityCode;
    private String startNo;
    private String endNo;
    private Integer sheets;
    private Date applyDate;
    private Integer type = 4;
}
