package com.service.base;

import com.service.base.util.ErrorLogUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BaseServiceApplication {

    public static void main(String[] args) {
        new ErrorLogUtil();
        SpringApplication.run(BaseServiceApplication.class, args);
    }

}
