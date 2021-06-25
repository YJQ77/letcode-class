package com.example.demo.util.clazz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/6/23 10:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassData {

    private String classCode;
    private Integer kps;

    void add(ClassData data) {
            this.kps += data.kps;
    }

    @Override
    public String toString() {
        return "ClassData{" +
                "classCode='" + classCode + '\'' +
                ", kps=" + kps +
                '}';
    }
}
