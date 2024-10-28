package com.springbootfinaltest.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "likedislikes")
@NoArgsConstructor
@AllArgsConstructor
public class LikeDisLikes {
    @Id
    @Column(name="id")
    @GeneratedValue
    private int id;
    @Column(name="post_id")
    private int post_id;
    @Column(name="user_id")
    private  int user_id;
    @Column(name="status")
    private int status;
    @Column(name="created_at")
    private String created_at;
    @Column(name="updated_at")
    private String updated_at;

}