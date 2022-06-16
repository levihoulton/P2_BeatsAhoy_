package com.revature.beats_ahoy.playlist;


import com.revature.beats_ahoy.users.UsersDao;
import com.revature.beats_ahoy.util.interfaces.Serviceable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlaylistServices implements Serviceable<Playlist> {

    private final PlaylistDao playlistDao;
    private final UsersDao usersDao;

    public PlaylistServices(PlaylistDao playlistDao, UsersDao usersDao) {
        this.playlistDao=playlistDao;
        this.usersDao=usersDao;
    }

    @Override
    public Playlist create(Playlist newPlaylist) {
        return playlistDao.save(newPlaylist);
    }

    @Override
    public List<Playlist> readAll() {
        return (List<Playlist>) playlistDao.findAll();
    }

    @Override
    public Playlist readById(String id) {

        return playlistDao.findById(Integer.valueOf(id)).get();
    }

    @Override
    public Playlist update(Playlist updatedPlaylist) {
        return playlistDao.save(updatedPlaylist);

    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean validateInput(Playlist object) {
        return false;
    }

}
