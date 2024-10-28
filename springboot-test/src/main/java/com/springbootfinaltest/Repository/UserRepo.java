package com.springbootfinaltest.Repository;

import com.springbootfinaltest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

    User findByEmail(String email);

    User findById(int id);
}
