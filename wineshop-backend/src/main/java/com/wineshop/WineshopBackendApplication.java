package com.wineshop;

import com.wineshop.model.User;
import com.wineshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WineshopBackendApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Override
    public void run(String... args) throws Exception {
        User user = new User("thinh", "123", "master");
        userService.register(user);
        System.out.println(userService.getAllUser());
    }

    public static void main(String[] args) {
        SpringApplication.run(WineshopBackendApplication.class, args);
    }
}
