package com.example.demo.eip;

import java.text.NumberFormat;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/5/28 14:02
 */
public class DataModel {

    private String qydm;
    private int glsl;
    private int jcsl;
    private String result;

    public DataModel() {
    }

    public DataModel(String qydm, int glsl, int jcsl) {
        this.qydm = qydm;
        this.glsl = glsl;
        this.jcsl = jcsl;
    }

    public DataModel add(DataModel model) {
        this.glsl += model.getGlsl();
        this.jcsl += model.getJcsl();
        return this;
    }

    public void add2(DataModel model) {
        this.glsl += model.getGlsl();
        this.jcsl += model.getJcsl();
    }

    public String jisuan(int num1, int num2) {
// 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
// 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);
        String result = (num1==0 || num2 ==0) ? "0.0" : numberFormat.format((float) num2 / (float) num1 * 100);
        return result + "%";
    }

    public String getQydm() {
        return qydm;
    }

    public void setQydm(String qydm) {
        this.qydm = qydm;
    }

    public int getGlsl() {
        return glsl;
    }

    public void setGlsl(int glsl) {
        this.glsl = glsl;
    }

    public int getJcsl() {
        return jcsl;
    }

    public void setJcsl(int jcsl) {
        this.jcsl = jcsl;
    }

    public String getResult() {
        return  this.jisuan(this.glsl,this.jcsl);
    }

    public void setResult() {
        this.result = this.jisuan(this.glsl,this.jcsl);
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "qydm='" + qydm + '\'' +
                ", glsl=" + glsl +
                ", jcsl=" + jcsl +
                ", result='" + result + '\'' +
                '}';
    }
}
