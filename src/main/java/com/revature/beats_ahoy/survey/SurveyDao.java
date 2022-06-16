package com.revature.beats_ahoy.survey;


import com.revature.beats_ahoy.users.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyDao extends CrudRepository<Survey, Integer> {

}
