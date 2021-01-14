package com.jeremy.bookkeeping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.jeremy.bookkeeping.mapper")
@SpringBootApplication
public class BookKeepingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookKeepingApplication.class, args);
    }

}
