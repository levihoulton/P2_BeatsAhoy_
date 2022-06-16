package com.revature.beats_ahoy.playlist;


import com.revature.beats_ahoy.survey.Survey;
import com.revature.beats_ahoy.users.Users;
import com.revature.beats_ahoy.users.UsersServices;
import com.revature.beats_ahoy.util.interfaces.Authable;
import com.revature.beats_ahoy.util.web.dto.PlaylistInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
public class PlaylistServlet  implements Authable {

    private final PlaylistServices playlistServices;
    private final UsersServices usersServices;
    @Autowired
    public PlaylistServlet(PlaylistServices playlistServices, UsersServices usersServices) {
        this.playlistServices = playlistServices;
        this.usersServices=usersServices;
    }
    //@CrossOrigin(value = "http://localhost:3000", allowCredentials = "true")
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addPlaylist")
    public ResponseEntity<Playlist> CreatePlaylist(@RequestBody PlaylistInit playlist){

        Playlist newPlaylist = new Playlist();
        newPlaylist.setUsernamePlaylist(usersServices.readById(playlist.getUsernamePlaylist()));
        newPlaylist.setUrl(playlist.getUrl());
        newPlaylist.setFieldOne(playlist.getFieldOne());
        newPlaylist.setFieldTwo(playlist.getFieldTwo());
        newPlaylist.setFieldThree(playlist.getFieldThree());
        newPlaylist.setFieldFour(playlist.getFieldFour());
        newPlaylist.setFieldFive(playlist.getFieldFive());

        Playlist playlist1 = playlistServices.create(newPlaylist);

        return new ResponseEntity<>(playlist1, HttpStatus.CREATED);

    }
    @PostMapping("/playlist")
    public ResponseEntity<Playlist> savePlaylists(@RequestBody Playlist playlist){
        Playlist newPlaylist = playlistServices. create(playlist);
        return new ResponseEntity<>(newPlaylist, HttpStatus.CREATED);
    }

    @GetMapping("/playlist/{id}")
    public ResponseEntity<Playlist> findPlaylistById(@PathVariable String results) {
        Playlist foundResults = playlistServices.readById(results);
        return new ResponseEntity<>(foundResults, HttpStatus.OK);
    }

    @GetMapping("/playlists")
    public ResponseEntity<List> findAllPlaylists(){
        return new ResponseEntity<>(playlistServices.readAll(), HttpStatus.I_AM_A_TEAPOT);
    }
}
