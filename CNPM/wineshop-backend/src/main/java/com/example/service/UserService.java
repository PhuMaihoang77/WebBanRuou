package com.example.service;

import com.example.model.Account;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Account register(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(passwordEncoder.encode(password));
        account.setRole("customer");
        try {
            return userRepository.save(account);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Tên tài khoản đã tồn tại!!");
        }
    }
    public List<Account> getAllAccount() {
        return userRepository.findAll();
    }

    public Account login(String username, String rawPassword) {
        Account account = userRepository.findAccountByUsername(username);
        if(account != null && passwordEncoder.matches(rawPassword, account.getPassword())){
            return account;
        }
        throw new RuntimeException("Tên đăng nhập hoặc mật khẩu không chính xác!");
    }

    public void deleteAccount(Account account) {
        userRepository.delete(account);
    }
}
