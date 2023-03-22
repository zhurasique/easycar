package com.service.auth;

import com.service.auth.domain.User;
import com.service.auth.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableDiscoveryClient
@EnableFeignClients
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

    @Bean
    public CommandLineRunner insertUserData(UserRepository userRepository) {
        return (args) -> {
            User user = new User();
            user.setUsername("user@gmail.com");
            user.setPassword("$2a$12$AXcFR1bWW55bQDUuqwmNyeWgiJgl5pmktHYMpd4xEqTCXYN5GTcly");
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("$2a$12$AXcFR1bWW55bQDUuqwmNyeWgiJgl5pmktHYMpd4xEqTCXYN5GTcly");

            userRepository.save(user);
            userRepository.save(admin);
        };
    }
}
