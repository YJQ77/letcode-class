package com.example.demo.study;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 描述：
 *$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu
 * @author yinjiaqi
 * @date 2021/4/6 13:38
 */
public class App {
        public static void main(String[] args) {
            String pwd = new BCryptPasswordEncoder().encode("123456");
            System.out.println(pwd);
        }
}
