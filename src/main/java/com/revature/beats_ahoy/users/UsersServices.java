package com.revature.beats_ahoy.users;


import com.revature.beats_ahoy.playlist.Playlist;
import com.revature.beats_ahoy.util.interfaces.Serviceable;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsersServices implements Serviceable<Users> {

    private UsersDao usersDao;

    @Autowired
    public UsersServices(UsersDao usersDao){
        this.usersDao=usersDao;
    }

    @Override
    public Users create(Users newUser) {
        //Todo: Change beow code to auth user
//        if(!validateInput(newTrainer)){ // checking if false
//            // TODO: throw - what's this keyword?
//            throw new com.revature.pokedex.util.exceptions.InvalidRequestException("User input was not validated, either empty String or null values");
//        }
//
//        // TODO: Will implement with JDBC (connecting to our database)
//        if(validateEmailNotUsed(newTrainer.getEmail())){
//            throw new com.revature.pokedex.util.exceptions.InvalidRequestException("User email is already in use. Please try again with another email or login into previous made account.");
//        }

        Users persistedUser = usersDao.save(newUser);

        //Todo: Change beow code to auth user

//        if(persistedTrainer == null){
//            throw new com.revature.pokedex.util.exceptions.ResourcePersistanceException("Trainer was not persisted to the database upon registration");
//        }
        return persistedUser;
    }

    @Override
    public List<Users> readAll() {
        List<Users> users = (List<Users>) usersDao.findAll();
        return users;
    }

    @Override
    public Users readById(String id) throws com.revature.pokedex.util.exceptions.ResourcePersistanceException {
        Users user = usersDao.findById(id).get();
        return user;
    }

    @Override
    public Users update(Users updatedUser) {
        usersDao.save(updatedUser);
        return updatedUser;
    }

    @Override
    public boolean delete(String username) {
        usersDao.deleteById(username);
        return true;
    }

    @Override
    public boolean validateInput(Users object) {
        return false;
    }
    public boolean validateUsernameNotUsed (String username){
        return usersDao.existsById(username);
    }

    public Users authenticateUser(String username, String password){

        if(password == null || password.trim().equals("") || username == null || username.trim().equals("")) {
            throw new com.revature.pokedex.util.exceptions.InvalidRequestException("Either email or password is an invalid entry. Please try logging in again");
        }

        Optional<Users> authenticateUser = usersDao.authenticateUser(username, password);

        if (!authenticateUser.isPresent()){
            throw new com.revature.pokedex.util.exceptions.AuthenticationException("Unauthenticated user, information provided was not consistent with our database.");
        }

        return authenticateUser.get();

    }
}

