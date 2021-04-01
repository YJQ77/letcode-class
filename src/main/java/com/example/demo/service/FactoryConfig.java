package com.example.demo.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/3/30 14:51
 */
@PropertySource(value = {"classpath:factory.properties"})
@ConfigurationProperties(prefix = "test")
@Component
public class FactoryConfig {
    private String account_service;
    private String account_dao_service;

    public String getAccount_service() {
        return account_service;
    }

    public void setAccount_service(String account_service) {
        this.account_service = account_service;
    }

    public String getAccount_dao_service() {
        return account_dao_service;
    }

    public void setAccount_dao_service(String account_dao_service) {
        this.account_dao_service = account_dao_service;
    }

    @Override
    public String toString() {
        return "FactoryConfig{" +
                "account_service='" + account_service + '\'' +
                ", account_dao_service='" + account_dao_service + '\'' +
                '}';
    }
}
