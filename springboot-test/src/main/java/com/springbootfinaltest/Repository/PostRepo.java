package com.springbootfinaltest.Repository;

import com.springbootfinaltest.Entity.LikeDisLikes;
import com.springbootfinaltest.Entity.Posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;

public interface PostRepo extends JpaRepository<Posts,Integer> {

  Posts findById(int id);

  @Query("SELECT p, COUNT(l) AS totallikes FROM Posts p JOIN LikeDisLikes l ON p.id = l.post_id WHERE l.status = 1 GROUP BY p ORDER BY totallikes DESC LIMIT :limitid")
  List<Object[]> findTopLikedPosts(@Param("limitid") int limitid);

  @Query("SELECT p, COUNT(l) AS totallikes FROM Posts p JOIN LikeDisLikes l ON p.id = l.post_id WHERE l.status = 2 GROUP BY p ORDER BY totallikes DESC LIMIT :limitid")
  List<Object[]> findTopDislikePosts(@Param("limitid") int limitid);

}
