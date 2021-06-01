package com.example.demo.stragegy;

import org.springframework.stereotype.Component;

/**
 * Created by admin on 2020/3/3 18:43:31.
 */
@Component
public class DZ01Strategy extends AbstrachStrategy {

    public DZ01Strategy() {
        super("zjdzpj.dz01");
    }
    
    @Override
    public void execute(String str) {
        System.out.println("BBB");
    }
}
