package com.devesh.ratingdataservices.model;

import java.util.List;

public class UserRating {

    private List<Rating> userRating;


    public List<Rating> getUserRating() {
        return userRating;
    }

    public UserRating setUserRating(List<Rating> userRating) {
        this.userRating = userRating;
        return this;
    }
}
