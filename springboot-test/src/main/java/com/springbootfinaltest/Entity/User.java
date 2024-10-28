package com.springbootfinaltest.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
   @Id
    @Column(name="id")
    @GeneratedValue
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private  String email;
    @Column(name="password")
    private String password;
    @Column(name="address")
    private String address;
    @Column(name="age")
    private int age;
    @Column(name="is_admin")
    private String is_admin;
    @Column(name="register_time")
    private String register_time;
    @Column(name="in_time")
    private String in_time;
    @Column(name="out_time")
    private String out_time;

}
