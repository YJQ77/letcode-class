package com.example.demo.elsfk;

import com.example.demo.elsfk.fk.*;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/4/1 15:37
 */
public class Tetromino {
    private Cell[] cell = new Cell[4];

    /**
     * 整体向左移动
     */
    protected void moveLeft() {
        for (Cell c : cell) {
            c.left();
        }
    }

    /**
     * 整体向右移动
     */
    protected void moveRight() {
        for (Cell c : cell) {
            c.right();
        }
    }

    /**
     * 整体向下移动
     */
    protected void moveDrop() {
        for (Cell c : cell) {
            c.drop();
        }
    }

    public static Tetromino buildOne() {
        Tetromino t = null;
        int i = (int) (Math.random() * 7);
        switch (i) {
            case 0:t=new T();break;
            case 1:t=new O();break;
            case 2:t=new I();break;
            case 3:t=new J();break;
            case 4:t=new L();break;
            case 5:t=new S();break;
            case 6:t=new Z();break;
        }
        return t;
    }

}
