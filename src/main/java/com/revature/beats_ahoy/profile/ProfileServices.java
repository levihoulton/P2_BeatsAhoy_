package com.revature.beats_ahoy.profile;


import com.revature.beats_ahoy.playlist.Playlist;
import com.revature.beats_ahoy.util.interfaces.Serviceable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProfileServices implements Serviceable<Profile> {

    private final ProfileDao profileDao;

    public ProfileServices(ProfileDao profileDao){
        this.profileDao=profileDao;
    }

    @Override
    public Profile create(Profile newProfile) {
        return profileDao.save(newProfile);
    }

    @Override
    public List<Profile> readAll() {
        return (List<Profile>) profileDao.findAll();
    }

    @Override
    public Profile readById(String id) {
        return profileDao.findById(Integer.valueOf(id)).get();
    }

    @Override
    public Profile update(Profile updatedProfile) {
        return profileDao.save(updatedProfile);
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean validateInput(Profile object) {
        return false;
    }

}
