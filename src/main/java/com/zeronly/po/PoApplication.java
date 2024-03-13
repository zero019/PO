package com.zeronly.po;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@MapperScan({"com.gitee.sunchenbin.mybatis.actable.dao.*"} )
@ComponentScan("com.gitee.sunchenbin.mybatis.actable.manager.*")
@SpringBootApplication
public class PoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoApplication.class, args);
    }

}
