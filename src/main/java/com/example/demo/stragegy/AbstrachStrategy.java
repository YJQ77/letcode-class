package com.example.demo.stragegy;


/**
 * Created by admin on 2020/3/3 18:43:01.
 */
public abstract class AbstrachStrategy {

    String name = "defaultName";
    
    public abstract void execute(String str);
    
    public AbstrachStrategy(String name) {
        this.name = name;
    }
}
