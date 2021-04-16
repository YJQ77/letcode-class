package com.example.demo.study.fanxing;

import java.io.Serializable;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/4/13 20:06
 */
public class Teacher implements Serializable {
    private Integer id;

    private String name;

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
}
