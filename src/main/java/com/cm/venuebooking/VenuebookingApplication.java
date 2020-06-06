package com.cm.venuebooking;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 场馆预订系统
 *
 * @author WenG
 */
@EnableSwagger2
@SpringBootApplication
@ComponentScan("com.cm")
@MapperScan({"com.cm.**.dao"})
public class VenuebookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(VenuebookingApplication.class, args);
    }

}
