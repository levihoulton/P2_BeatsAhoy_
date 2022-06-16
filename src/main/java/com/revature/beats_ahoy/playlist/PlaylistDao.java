package com.revature.beats_ahoy.playlist;


import com.revature.beats_ahoy.users.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistDao extends CrudRepository<Playlist, Integer> {

}
