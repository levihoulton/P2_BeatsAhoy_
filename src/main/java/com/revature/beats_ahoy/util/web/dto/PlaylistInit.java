package com.revature.beats_ahoy.util.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.revature.beats_ahoy.users.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistInit {

    private String usernamePlaylist;
    private String url;
    private String fieldOne;
    private String fieldTwo;
    private String fieldThree;
    private String fieldFour;
    private String fieldFive;

}