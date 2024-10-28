package com.springbootfinaltest.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
public class Posts {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "created_time")
    private String register_time;

    @Column(name = "updated_time")
    private String updated_time;
}

