package br.com.fiap.mymovie.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final   MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository, MovieRepository movieRepository1) {
        this.movieRepository = movieRepository1;
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie save(Movie movie){
        return movieRepository.save(movie);
    }
}
