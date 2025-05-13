package com.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    @Temporal(TemporalType.TIMESTAMP)
    private String DoB;
    private String gender;
    private String image;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;

    public Customer() {
    }

    public Customer(String fullName, String email, String phone, String address, String doB, String gender, String image) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.DoB = doB;
        this.gender = gender;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getDoB() {
        return DoB;
    }

    public String getGender() {
        return gender;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDoB(String doB) {
        DoB = doB;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Customer(Long id, String fullName, String email, String phone, String address, String doB, String gender, String image, List<Account> accounts) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        DoB = doB;
        this.gender = gender;
        this.image = image;
        this.accounts = accounts;
    }
}
