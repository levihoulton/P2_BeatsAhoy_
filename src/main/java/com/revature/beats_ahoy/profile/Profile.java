package com.revature.beats_ahoy.profile;



import com.revature.beats_ahoy.users.Users;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;



@Data // this handles toString, hashCode, equals() and your getters and setters
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profile")
public class Profile {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @OneToOne(optional = false)
    @JoinColumn(name = "username_profile", referencedColumnName = "username")
    private Users usernameProfile;
    private String favoriteGenre;
    private String favoriteSong;
    private String favoriteArtist;
    private String favoriteAlbum;

}
