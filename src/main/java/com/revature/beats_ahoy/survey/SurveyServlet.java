package com.revature.beats_ahoy.survey;


import com.revature.beats_ahoy.users.Users;
import com.revature.beats_ahoy.util.interfaces.Authable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SurveyServlet  implements Authable {

    private final SurveyServices surveyServices;

    @Autowired
    public SurveyServlet(SurveyServices surveyServices) {
        this.surveyServices = surveyServices;
    }

    @PostMapping("/result")
    public ResponseEntity<Survey> saveUser(@RequestBody Survey result) {
        Survey survey = surveyServices.create(result);
        return new ResponseEntity<>(survey, HttpStatus.CREATED);
    }

    @GetMapping("/results/{id}")
    public ResponseEntity<Survey> findUserById(@PathVariable String results) {
        Survey foundResults = surveyServices.readById(results);
        return new ResponseEntity<>(foundResults, HttpStatus.OK);
    }

    @GetMapping("/results")
    public ResponseEntity<List> findAllUsers(){
        return new ResponseEntity<>(surveyServices.readAll(), HttpStatus.I_AM_A_TEAPOT);
    }

}
