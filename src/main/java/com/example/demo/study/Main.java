package com.example.demo.study;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/3/30 16:31
 */
public class Main {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDate.parse("2021-02-28").atStartOfDay().plusDays(-1);
        System.out.println(localDateTime);
    }
}
