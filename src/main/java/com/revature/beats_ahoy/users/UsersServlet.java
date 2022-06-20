package com.revature.beats_ahoy.users;


import com.revature.beats_ahoy.util.interfaces.Authable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UsersServlet implements Authable {

    private final UsersServices usersServices;

    @Autowired
    public UsersServlet(UsersServices usersServices){
        this.usersServices=usersServices;
    }

    @PostMapping("/register")
    public ResponseEntity<Users> saveUser(@RequestBody Users user){
        Users newUser = usersServices. create(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @PutMapping("/register")
    public ResponseEntity<Users> updateUser(@RequestBody Users user){
        Users newUser = usersServices.update(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @GetMapping("/users")
    public ResponseEntity<List> findAllUsers(){
        return new ResponseEntity<>(usersServices.readAll(), HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping("/userEx")
    public void userEx(){
        throw new com.revature.pokedex.util.exceptions.AuthenticationException("Oh no User not auth");
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<Users> findUserById(@PathVariable String username){
        Users foundUser = usersServices.readById(username);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }
//    @GetMapping("/users")
//    public Users findUserByIddQueryParam(@RequestParam String username){
//        Users foundUser = usersServices.readById(username);
//        return foundUser;
//    }
    @GetMapping("/data")
    public int showDataTypeInPath(@RequestParam int x){
        return x;
    }






}
