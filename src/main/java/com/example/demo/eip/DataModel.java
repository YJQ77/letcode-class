package com.example.demo.eip;

import java.text.NumberFormat;
import lombok.Data;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/5/28 14:02
 */
@Data
public class DataModel {

    private String qydm;
    private String qydmName;

    private int zj;
    private int kpzj;

    private int glsl;
    private int kpglsl;

    private int jcsl;
    private int kpjcsl;

    private int xzdw;
    private int kpxzdw;


    private String result;
    private String result2;
    private String result3;

    public DataModel() {
    }

    public DataModel(DataModel model) {
        this.qydm = model.getQydm();
        this.glsl = model.getGlsl();
        this.kpglsl = model.getKpglsl();
        this.jcsl = model.getJcsl();
        this.kpjcsl = model.getKpjcsl();
        this.xzdw = model.getXzdw();
        this.kpxzdw = model.getKpxzdw();
    }

    public DataModel(String qydm, int glsl, int kpglsl, int jcsl, int kpjcsl, int xzdw, int kpxzdw) {
        this.qydm = qydm;
        this.glsl = glsl;
        this.kpglsl = kpglsl;
        this.jcsl = jcsl;
        this.kpjcsl = kpjcsl;
        this.xzdw = xzdw;
        this.kpxzdw = kpxzdw;
    }

    public DataModel(String qydm, int glsl, int kpglsl, int jcsl, int kpjcsl) {
        this.qydm = qydm;
        this.glsl = glsl;
        this.kpglsl = kpglsl;
        this.jcsl = jcsl;
        this.kpjcsl = kpjcsl;
    }

    public DataModel(String qydm,int xzdw, int kpxzdw) {
        this.qydm = qydm;
        this.xzdw = xzdw;
        this.kpxzdw = kpxzdw;
    }

    public DataModel add(DataModel model) {
        this.xzdw = model.getXzdw();
        this.kpxzdw = model.getKpxzdw();
        return this;
    }

//    public DataModel add3(DataModel model) {
//        model.setGlsl(model.getGlsl() + this.glsl);
//        model.setKpglsl(model.getKpglsl() + this.kpglsl);
//        model.setJcsl(model.getJcsl() + this.jcsl);
//        model.setKpjcsl(model.getKpjcsl() + this.kpjcsl);
//        model.setXzdw(model.getXzdw() + this.xzdw);
//        model.setKpxzdw(model.getKpxzdw() + this.kpxzdw);
//        return model;
//    }

    public void add2(DataModel model) {
        this.glsl += model.getGlsl();
        this.kpglsl += model.getKpglsl();
        this.jcsl += model.getJcsl();
        this.kpjcsl += model.getKpjcsl();
        this.xzdw += model.getXzdw();
        this.kpxzdw += model.getKpxzdw();
    }


    public void setZj() {
        this.zj = this.glsl + this.jcsl + this.xzdw;
    }

    public void setKpzj() {
        this.kpzj = this.kpglsl + this.kpjcsl + this.kpxzdw;
    }

//    public String getResult() {
//        return  this.jisuan(this.glsl,this.kpglsl);
//    }
//
//    public void setResult() {
//        this.result = this.jisuan(this.glsl,this.kpglsl);
//    }
//
//    public String getResult2() {
//        return  this.jisuan(this.jcsl,this.kpjcsl);
//    }
//
//    public void setResult2() {
//        this.result2 = this.jisuan(this.jcsl,this.kpjcsl);
//    }
//
//    public String getResult3() {
//        return  this.jisuan(this.zj,this.kpzj);
//    }
//
//    public void setResult3() {
//        this.result3 = this.jisuan(this.zj,this.kpzj);
//    }


    public String jisuan(int num1, int num2) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        String result = (num1 == 0 || num2 == 0) ? "0.0" : numberFormat.format((float) num2 / (float) num1 * 100);
        return result + "%";
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "qydm='" + qydm + '\'' +
                ", zj=" + zj +
                ", kpzj=" + kpzj +
                ", glsl=" + glsl +
                ", kpglsl=" + kpglsl +
                ", jcsl=" + jcsl +
                ", kpjcsl=" + kpjcsl +
                ", xzdw=" + xzdw +
                ", kpxzdw=" + kpxzdw +
                '}';
    }
}
