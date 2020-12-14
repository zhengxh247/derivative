package com.team.derivative.admin;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengxh
 */
@EnableSwagger2Doc
@SpringBootApplication(scanBasePackages = "com.team")
@MapperScan("com.team.derivative.admin.dao")
@RestController
public class HypermarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(HypermarketApplication.class,args);
    }

}


