package com.devesh.moviescatalogservices.resource;

import com.devesh.moviescatalogservices.model.CatalogItem;
import com.devesh.moviescatalogservices.model.Movie;
import com.devesh.moviescatalogservices.model.Rating;
import com.devesh.moviescatalogservices.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogueResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){



        //get All rated movies Id
/*
        List<Rating>ratings= Arrays.asList(
                new Rating("1234",5),
                new Rating("76578",7)
        );*/

        UserRating userRating= restTemplate.getForObject(("http://rating-data-service/ratingdata/users/"+userId), UserRating.class);

        return userRating.getUserRating().stream().map(rating->{
            //for each movie Id call movie Info service and get details
            Movie movie=restTemplate.getForObject("http://movie-info-service/movies/foo"+rating.getMovieId(), Movie.class);

            //put them all together
          return   new CatalogItem(movie.getName(),"desc",rating.getRating());

        }).collect(Collectors.toList());



        /*return Collections.singletonList(
                new CatalogItem("Transformer","Test",4)

        );*/
    }
}
