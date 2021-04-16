package com.example.demo.study.fanxing;

import java.io.Serializable;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/4/13 20:06
 */
public class Student implements Serializable {
    private Integer id;

    private String name;

    private int socre;

    public Student() {
    }

    public Student(Integer id, String name, int socre) {
        this.id = id;
        this.name = name;
        this.socre = socre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSocre() {
        return socre;
    }

    public void setSocre(int socre) {
        this.socre = socre;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", socre=" + socre +
                '}';
    }
}
