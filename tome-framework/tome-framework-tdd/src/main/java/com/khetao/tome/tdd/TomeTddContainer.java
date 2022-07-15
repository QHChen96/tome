package com.khetao.tome.tdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author chenqinhao 2022/7/16
 * @email qhchen96@gmail.com
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.khetao.tome")

public class TomeTddContainer {

    public static void main(String[] args) {
        SpringApplication.run(TomeTddContainer.class, args);
    }

}
