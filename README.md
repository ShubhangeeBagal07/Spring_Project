# Spring_Project
- User API and Post API

 1]Tools which Required -

     1.IntelliJ IDEA  
     2.MySQL Workbeanch.
     3.Postman.
  
 2] Some commonly used libraries and dependencies in project:
  
     1.Spring Boot: The core framework for building the API.
     2.Spring Web: Provides support for building RESTful APIs.
     3.Spring Data JPA: Simplifies working with databases and enables object-relational mapping.
     4.Lombok: Reduces boilerplate code by automatically generating getters, setters, and constructors.
     5.MySQL Connector/J: The official JDBC driver for MySQL database connectivity.

 3]Apis collections-
  1. Post -http://localhost:8080/register-This Api used to register the user.
   
 Raw Data- {
    "name" : "Demo User2",
    "email" : "demouser2@gmail.com",
    "password" : "demo@123",
    "address" : "MH",
    "age" : 24
}

  2.Post -http://localhost:8080/login
Raw Data-
     {
    "email" : "admin@gmail.com",
    "password" : "admin@123"
     }
   
  3.GET-ViewAllUsers If Admin-
    http://localhost:8080/1/viewusers - if the user is admin so they can see the all users data using this Api.


  4.Post-Create Post Api- To create the post used this Api.
                 http://localhost:8080/postcreated

 Raw Data -{
    "title" : "Hii This is Post Title",
    "content" : "Hello This is Post Content  ",
    "user_id" : 1,
    "id" : 1
    }



  5.GET-Get Post by user_id - To get the post using the user id and post_id
                            -http://localhost:8080/2/2


 6.POST-Like Dislike Post Api-
   http://localhost:8080/likedislike- to post the like or dislike we need to provide the id of user ,post_id and the status which we want like or dislike 
    1 for like and the 2 for dislike the comment.
 Raw data- 
                           {
                            "user_id" : 2,
                             "post_id" : 2,
                             "status" : 1
                             }
   

 7.GET-Top Likes Custom Option Api-

    http://localhost:8080/toplikes/10 -To get the top Like post using this api we can provide the limit to get the top most like status as result.

 8.Top Dislikes Custom Option Api-

     http://localhost:8080/topdislike/10 - To get the top Dislike post using this api we can provide the limit to get the top most dislike status as result.











