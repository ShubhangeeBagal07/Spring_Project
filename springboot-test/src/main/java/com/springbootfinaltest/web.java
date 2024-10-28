package com.springbootfinaltest;

import com.springbootfinaltest.Controller.LoginRequest;
import com.springbootfinaltest.Entity.LikeDisLikes;
import com.springbootfinaltest.Entity.Posts;
import com.springbootfinaltest.Entity.User;
import com.springbootfinaltest.Service.LikeService;
import com.springbootfinaltest.Service.PostService;
import com.springbootfinaltest.Service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class web {

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postsService;

    @Autowired
    private LikeService likeService;


    //Login Endpoint
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
        // Process the login request
        Map<String, String> data = new HashMap<>();
        User result  = userService.getDetailsByEmail(loginRequest.getEmail());
        if(result != null  && (result.getPassword().equals(loginRequest.getPassword()))){
            data.put("age",  String.valueOf(result.getAge()));
            data.put("address", result.getAddress());
            data.put("email", result.getEmail());
            data.put("name", result.getName());
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login Failed");
        }
    }


    //register EndPoint
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody User user){
        Map<String, String> data = new HashMap<>();
        User result = userService.saveDetails(user);
        if(result != null){
            data.put("age",  String.valueOf(result.getAge()));
            data.put("address", result.getAddress());
            data.put("email", result.getEmail());
            data.put("name", result.getName());
            return new ResponseEntity<>(data, HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User Not Registered");
        }
    }


    //if admin view users all profiles
    @GetMapping("/{id}/viewusers")
    public ResponseEntity<Object> viewUsers(@PathVariable int id){
        List<User> result = userService.viewUsers(id);
        if(result != null){
            List<Object> objects = new ArrayList<>();
            for (User result1 : result) {
                Object obj = createObjectFromRecord(result1); // create an object using the record data
                objects.add(obj); // add the object to the list
            }
            return new ResponseEntity<>(objects, HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You are not Admin so We can't show you Data");
        }
    }


    //post created Controller or if exist then update here
    @PostMapping("/postcreated")
    public ResponseEntity<Object> postCreated(@RequestBody Posts posts){
        Map<String, String> data = new HashMap<>();
        Posts result = postsService.savePosts(posts);
        if(result != null){
            data.put("content",  result.getContent());
            data.put("title", result.getTitle());
            data.put("id", String.valueOf(result.getId()));
            return new ResponseEntity<>(data, HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User id not exists so we can create Post");
        }
    }

    //get post by user_id
    @GetMapping("/{userid}/{postid}")
    public ResponseEntity<Object> postCreated(@PathVariable int userid, @PathVariable int postid){
        Map<String, String> data = new HashMap<>();
        Posts result = postsService.getPostById(postid);
        int likes = likeService.getLikesByPostId(postid); //get total likes
        int dislikes = likeService.getDislikesByPostId(postid); //get total dislikes
        if(result != null && (result.getUser_id() == userid)){
            data.put("dislikes", String.valueOf(dislikes));
            data.put("likes", String.valueOf(likes));
            data.put("content",  result.getContent());
            data.put("title", result.getTitle());
            data.put("id", String.valueOf(result.getId()));
            return new ResponseEntity<>(data, HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Post Does not Exists...");
        }
    }

    //    //like dislike reqiest
    @PostMapping("/likedislike")
    public ResponseEntity<Object> postCreated(@RequestBody LikeDisLikes likedislike){
        Map<String, String> data = new HashMap<>();
        String result = likeService.setLikeDislike(likedislike);
        if(result != null){
            data.put("data",  result);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Provided user and post data doesn't match with any records.....");
        }
    }


    //get top like posts
    @GetMapping("/toplikes/{limitid}")
    public ResponseEntity<Object> topLikesPosts(@PathVariable int limitid){
        Map<String, String> data = new HashMap<>();
        List<Object[]> result = postsService.getTopLikesPosts(limitid);
        if(result != null){
            List<Object> objects = new ArrayList<>();
            for (Object[] result1 : result) {
                Object obj = createObjectFromRecord1(result1); // create an object using the record data
                objects.add(obj); // add the object to the list
            }
            return new ResponseEntity<>(objects, HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Their is not likes posts....");
        }
    }

    //get top dislike posts
    @GetMapping("/topdislike/{limitid}")
    public ResponseEntity<Object> topDislikePosts(@PathVariable int limitid){
        Map<String, String> data = new HashMap<>();
        List<Object[]> result = postsService.getTopDislikePosts(limitid);
        if(result != null){
            List<Object> objects = new ArrayList<>();
            for (Object[] result1 : result) {
                Object obj = createObjectFromRecord1(result1); // create an object using the record data
                objects.add(obj); // add the object to the list
            }
            return new ResponseEntity<>(objects, HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Their is not dislikes posts....");
        }
    }


    public Map<String, String> createObjectFromRecord(User user) {
        Map<String, String> data = new HashMap<>();
        data.put("age",  String.valueOf(user.getAge()));
        data.put("address", user.getAddress());
        data.put("email", user.getEmail());
        data.put("name", user.getName());
        data.put("id", String.valueOf(user.getId()));
        return data;
    }

    public Map<String, String> createObjectFromRecord1(Object posts) {
        Map<String, String> data = new HashMap<>();

        Object[] postArray = (Object[]) posts; // Cast the posts object to Object[]
        Posts post = (Posts) postArray[0]; // Cast the first element to Posts type

        data.put("User Id", String.valueOf(post.getUser_id()));
        data.put("title", post.getTitle());
        data.put("content", post.getContent());
        data.put("Post Id", String.valueOf(post.getId()));
        data.put("totalLikes", String.valueOf(postArray[1]));

        return data;
    }

}
