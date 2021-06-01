package com.example.demo.stragegy;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2020/3/3 18:50:28.
 */
@Component
public class StrategyHolder {
    
    // 执行顺序 Constructor >> @Autowired >> @PostConstruct
    // 关键功能 Spring 会自动将 MyStrategy 接口的类注入到这个Map中
    @Autowired
    Map<String, AbstrachStrategy> myStrategyMap;
    
    private Map<String, AbstrachStrategy> strategyNameMap = new HashMap<>();
    
    public AbstrachStrategy getByBeanName(String beanName) {
        return myStrategyMap.get(beanName);
    }
    
    public AbstrachStrategy getByStrategyName(String strategyName) {
        return strategyNameMap.get(strategyName);
    }
    
    @PostConstruct
    public void init() {
        myStrategyMap.values().forEach(x -> {
            strategyNameMap.put(x.name, x);
        });
    }
    
}
