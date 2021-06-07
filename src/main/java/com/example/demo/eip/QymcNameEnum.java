package com.example.demo.eip;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/6/7 10:28
 */
public enum QymcNameEnum {
    ZJ("000000","总计"),
    A("330100","杭州市"),
    B("330102","上城区"),
    C("330103","下城区"),
    D("330200","宁波市"),
    E("330203","海曙区"),
    F("330204","江北区"),
    G("330206","北仑区"),
    H("330300","温州市"),
    I("330307","鹿城区"),
    J("330308","龙湾区");
    private String code;
    private String name;

    QymcNameEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getNameByCode(String code){
        QymcNameEnum[] values = QymcNameEnum.values();
        String name = "";
        for (QymcNameEnum e:values){
            if (e.code.equals(code)){
                name = e.getName();
            }
        }
        return name;
    }
}
