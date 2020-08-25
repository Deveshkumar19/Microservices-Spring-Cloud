package com.devesh.ratingdataservices.resources;

import com.devesh.ratingdataservices.model.Rating;
import com.devesh.ratingdataservices.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingdata")
public class RatingResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){

        return new Rating(movieId,4);
    }

    @RequestMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String movieId){

        List<Rating> ratingList= Arrays.asList(
                new Rating("1234",5),
                new Rating("76578",7)

        );

        UserRating userRating=new UserRating();
        userRating.setUserRating(ratingList);
        return userRating;
    }
}
