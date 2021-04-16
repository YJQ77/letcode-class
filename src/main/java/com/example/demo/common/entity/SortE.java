package com.example.demo.common.entity;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/4/15 13:28
 */
public class SortE implements Comparable<SortE>{
    private int id;

    public SortE() {
    }

    public SortE(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(SortE o) {
        return o.getId() - this.getId();
    }

    @Override
    public String toString() {
        return "SortE{" +
                "id=" + id +
                '}';
    }
}
