package com.example.talentrank;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.talentrank.mapper")
public class TalentRankApplication {

    public static void main(String[] args) {
        SpringApplication.run(TalentRankApplication.class, args);
    }

}
