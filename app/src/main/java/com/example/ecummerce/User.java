package com.example.ecummerce;

import java.util.HashMap;
import java.util.Map;

public class User {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    private String id;

    public User(String id, String email, String password, String phone_number, String full_name, String address, String type, int age) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.full_name = full_name;
        this.address = address;
        this.type = type;
        this.age = age;
    }

    private String email;
    private String password;
    private String phone_number;
    private String full_name;
    private String address;
    private String type;
    private int age;

    public User(String email, String password, String phone_number, String full_name, String address, String type, int age) {
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.full_name = full_name;
        this.address = address;
        this.type = type;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map addToMap(){
        Map m = new HashMap();
        m.put("email", email);
        m.put("password", password);
        m.put("phone_number", phone_number);
        m.put("full_name", full_name);
        m.put("address", address);
        m.put("type", type);
        m.put("age", age);

        return m;
    }


}
