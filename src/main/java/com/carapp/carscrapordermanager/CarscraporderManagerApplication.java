package com.carapp.carscrapordermanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.carapp.carscrapordermanager.mapper"})
public class CarscraporderManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarscraporderManagerApplication.class, args);
    }

}
