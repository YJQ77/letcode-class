package com.example.demo.elsfk;

import lombok.Data;

import java.awt.image.BufferedImage;

/**
 * 描述：方格类
 *
 * @author yinjiaqi
 * @date 2021/4/1 15:32
 */
@Data
public class Cell {
    private int row;//行
    private int col;//列
    private BufferedImage bufferedImage;//图片

    public Cell() {
    }

    public Cell(int row, int col, BufferedImage bufferedImage) {
        this.row = row;
        this.col = col;
        this.bufferedImage = bufferedImage;
    }
    /** 左移 */
    protected void left (){
        row--;
    }
    /** 右移 */
    protected void right (){
        row++;
    }
    /** 下移 */
    protected void drop (){
        col--;
    }


}
