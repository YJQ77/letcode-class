package com.example.demo.eip;

import java.util.Arrays;
import java.util.List;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/6/7 10:28
 */
public enum DanWeiEnum {
    ZJ("0", Arrays.asList("zj","kpzj"),"总计"),
    A("1", Arrays.asList("glsl","kpglsl"),"公立医院"),
    B("2", Arrays.asList("jcsl","kpjcsl"),"基层医院"),
    C("3", Arrays.asList("xzdw","kpxzdw"),"行政单位");
    private String code;
    private List<String> name;
    private String value;

    DanWeiEnum(String code, List<String> name,String value) {
        this.code = code;
        this.name = name;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public List<String> getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public static List<String> getNameByCode(String code) {
        DanWeiEnum[] values = DanWeiEnum.values();
        List<String> name = null;
        for (DanWeiEnum e : values) {
            if (e.code.equals(code)) {
                name = e.getName();
            }
        }
        return name;
    }
    public static String getValueByCode(String code) {
        DanWeiEnum[] values = DanWeiEnum.values();
        String value = null;
        for (DanWeiEnum e : values) {
            if (e.code.equals(code)) {
                value = e.getValue();
            }
        }
        return value;
    }

}
