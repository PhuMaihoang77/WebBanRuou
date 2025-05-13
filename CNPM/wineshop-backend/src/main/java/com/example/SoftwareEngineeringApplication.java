package com.example;

import com.example.model.Account;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.service.UserService;

@SpringBootApplication
public class SoftwareEngineeringApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
//        userService.register("longtran", "1");
//        Account account = userRepository.findById(4L).orElse(null);
//        userService.deleteAccount(account);
//        System.out.println(userService.getAllAccount());
//        System.out.println(userService.login("phnha", "1"));
    }

    public static void main(String[] args) {
        SpringApplication.run(SoftwareEngineeringApplication.class, args);
    }

}
