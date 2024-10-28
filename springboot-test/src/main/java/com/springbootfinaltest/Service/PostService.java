package com.springbootfinaltest.Service;

import com.springbootfinaltest.Entity.LikeDisLikes;
import com.springbootfinaltest.Entity.Posts;
import com.springbootfinaltest.Entity.User;
import com.springbootfinaltest.Repository.LikeRepo;
import com.springbootfinaltest.Repository.PostRepo;
import com.springbootfinaltest.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepo postsRepo;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private LikeRepo likeRepo;

    public Posts savePosts(Posts posts) {
        int user_id = posts.getUser_id();
        int post_id = posts.getId();
        User user = userRepo.findById(user_id);
        Posts posts1 = postsRepo.findById(post_id);
        if (posts1 != null && user != null) {
            posts1.setTitle(posts.getTitle());
            posts1.setContent(posts.getContent());
            posts1.setUser_id(posts.getUser_id());
            Posts save = postsRepo.save(posts1);
            return save;
        } else if (user != null) {
            Posts save1 = postsRepo.save(posts);
            return save1;
        } else {
            return null;
        }

    }

    public Posts getPostById(int post_id) {
        Posts post = postsRepo.findById(post_id);
        if (post != null) {
            return post;
        }
        return null;
    }

    public List<Object[]> getTopLikesPosts(int limitid){
        List<Object[]> posts = postsRepo.findTopLikedPosts(limitid);
        return posts;
    }

    public List<Object[]> getTopDislikePosts(int limitid){
        List<Object[]> posts = postsRepo.findTopDislikePosts(limitid);
        return posts;
    }

}
