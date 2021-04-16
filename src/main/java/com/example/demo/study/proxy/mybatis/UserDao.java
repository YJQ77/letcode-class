package com.example.demo.study.proxy.mybatis;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/4/16 14:04
 */
public interface UserDao {
    @Select("select * from xxx")
    String select();
}
