package com.springbootfinaltest.Service;

import com.springbootfinaltest.Entity.LikeDisLikes;
import com.springbootfinaltest.Entity.Posts;
import com.springbootfinaltest.Entity.User;
import com.springbootfinaltest.Repository.LikeRepo;
import com.springbootfinaltest.Repository.PostRepo;
import com.springbootfinaltest.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    @Autowired
    private PostRepo postsRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private LikeRepo likeRepo;

    public String setLikeDislike(LikeDisLikes likedislike){
        Posts post = postsRepo.findById(likedislike.getPost_id());
        User user = userRepo.findById(likedislike.getUser_id());
        if(post != null && user !=null){
            LikeDisLikes like = likeRepo.findByPostIdAndUserId(likedislike.getPost_id(), likedislike.getUser_id());
            if(like == null && likedislike.getStatus() != 2){ //first time we cant apply dislike status for that situation we are checking.
                likeRepo.save(likedislike);
                return  "Successfully like it.....";
            } else if (like != null && ((like.getStatus() == 1) && (likedislike.getStatus() == 2))) {
                like.setStatus(likedislike.getStatus()); //check if like it already and user want to dislike it this candition controle here
                likeRepo.save(like);
                return "SuccessFully Dislike it....";
            } else if(like != null && ((like.getStatus() == 2) && (likedislike.getStatus() == 1))){
                like.setStatus(likedislike.getStatus()); //if user like first after that he will dislike or user again want to like it this condition control here
                likeRepo.save(like);
                return "Successfully like it again.....";
            }else if(like != null && ((like.getStatus() == 1) && (likedislike.getStatus() == 1))){
                return "You already like it this post.....";
            }else if(like != null && ((like.getStatus() == 2) && (likedislike.getStatus() == 2))){
                return "You already dislike it this post.....";
            }else{
                return "You Can't dislike it because first need to like on post.....";
            }
        }else{
            return null;
        }
    }



    //get likes by postId
    public int getLikesByPostId(int post_id){
        int likes = likeRepo.getLikesByPostId(post_id);
        return likes;
    }

    public int getDislikesByPostId(int post_id){
        int dislikes = likeRepo.getDislikesByPostId(post_id);
        return dislikes;
    }

}
