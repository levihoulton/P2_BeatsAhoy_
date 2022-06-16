package com.revature.beats_ahoy.users;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsersDao extends CrudRepository<Users, String> {

    @Query(value = "FROM Users WHERE username= :username AND password = :password")
    Optional<Users> authenticateUser(String username, String password);
}
