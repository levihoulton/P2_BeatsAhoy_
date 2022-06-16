package com.revature.beats_ahoy.profile;


import com.revature.beats_ahoy.survey.Survey;
import com.revature.beats_ahoy.util.interfaces.Authable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class ProfileServlet  implements Authable{

    private final ProfileServices profileServices;

    @Autowired
    public ProfileServlet(ProfileServices profileServices){
        this.profileServices = profileServices;
    }

    @PostMapping("/profile")
    public ResponseEntity<Profile> saveUser(@RequestBody Profile result) {
        Profile profile = profileServices.create(result);
        return new ResponseEntity<>(profile, HttpStatus.CREATED);
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<Profile> findUserById(@PathVariable String id) {
        Profile profile = profileServices.readById(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @GetMapping("/profiles")
    public ResponseEntity<List> findAllUsers(){
        return new ResponseEntity<>(profileServices.readAll(), HttpStatus.I_AM_A_TEAPOT);
    }

}
