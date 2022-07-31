package com.feng.admin;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * 平台运营管理微服务启动类
 * @author f
 * @date 2022/7/31 15:37
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.feng.admin")
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                             start success                                        ");
        System.out.println("----------------------------------------------------------------------------------");
    }

    /**
     * 分页插件
     * @return 分页bean
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
