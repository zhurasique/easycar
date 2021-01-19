package com.easy.car;

import com.easy.car.util.ErrorLogUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarApplication {

    public static void main(String[] args) {
        ErrorLogUtil errorLogUtil = new ErrorLogUtil();
        SpringApplication.run(CarApplication.class, args);
    }

}
