package com.studyolle.settings;

import com.studyolle.domain.Account;
import lombok.Data;

@Data
public class Profile {
    private String bio;

    private String url;

    private String occupation;

    private String location; //varchar(255)

    public Profile(Account account) { //modelMapper 참조
        this.bio = account.getBio();
        this.url = account.getUrl();
        this.occupation = account.getOccupation();
        this.location = account.getLocation();
    }
}
