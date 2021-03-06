
package com.tuhu.future;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;

/**
 * 启动入口
 * 
 * @author duyashuo
 * @EnableDubboConfiguration
 */
@SpringBootApplication
@MapperScan({ "com.tuhu.future.mybatis.integration.dal" })
public class AppMain {

    public static void main(String[] args) {
        SpringApplication.run(AppMain.class, args);
    }

}
