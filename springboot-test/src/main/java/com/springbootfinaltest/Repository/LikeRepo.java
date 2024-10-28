package com.springbootfinaltest.Repository;

import com.springbootfinaltest.Entity.LikeDisLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LikeRepo extends JpaRepository<LikeDisLikes,Integer> {
    LikeDisLikes findById(int id);
    @Query("SELECT l FROM LikeDisLikes l WHERE l.post_id = :post_id AND l.user_id = :user_id")
    LikeDisLikes findByPostIdAndUserId(@Param("post_id") int post_id, @Param("user_id") int user_id);

    @Query("SELECT COUNT(*) AS totalLikes FROM LikeDisLikes l WHERE l.post_id = :post_id AND l.status = 1")
    int getLikesByPostId(@Param("post_id") int post_id);

    @Query("SELECT COUNT(*) AS totalLikes FROM LikeDisLikes l WHERE l.post_id = :post_id AND l.status = 2")
    int getDislikesByPostId(@Param("post_id") int post_id);
}
