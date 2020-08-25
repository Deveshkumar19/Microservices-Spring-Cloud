package com.devesh.moviescatalogservices.model;

import java.util.List;

public class UserRating {

    private List<Rating> userRating;

    public UserRating(){


    }

    public List<Rating> getUserRating() {
        return userRating;
    }

    public UserRating setUserRating(List<Rating> userRating) {
        this.userRating = userRating;
        return this;
    }
}
