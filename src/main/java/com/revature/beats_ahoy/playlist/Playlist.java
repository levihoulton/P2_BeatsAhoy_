package com.revature.beats_ahoy.playlist;



import com.revature.beats_ahoy.users.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data // this handles toString, hashCode, equals() and your getters and setters
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "playlist")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "username_playlist", referencedColumnName = "username")
    private Users usernamePlaylist;
    private String url;
    private String fieldOne;
    private String fieldTwo;
    private String fieldThree;
    private String fieldFour;
    private String fieldFive;
}