package com.mycomp.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/*
 * Mybatis工具类
 */

public class MybatisUtils {
    private static final SqlSessionFactory SESSION_FACTORY;

    static {
        // 1. 创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 2. 读取配置文件
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("SqlMappingConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. 加载配置文件, 获取session工厂
        SESSION_FACTORY = sqlSessionFactoryBuilder.build(resourceAsStream);
    }

    public static SqlSession openSession() {
        return SESSION_FACTORY.openSession();
    }
}
