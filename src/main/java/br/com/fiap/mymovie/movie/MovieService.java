package br.com.fiap.mymovie.movie;

import br.com.fiap.mymovie.config.MessageHelper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final   MovieRepository movieRepository;
    private final MessageHelper messageHelper;

    public MovieService(MovieRepository movieRepository, MovieRepository movieRepository1, MessageHelper messageHelper) {
        this.movieRepository = movieRepository1;
        this.messageHelper = messageHelper;
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie save(Movie movie){
        return movieRepository.save(movie);
    }

    public void deleteById(Long id) {
        movieRepository.delete(getMovie(id));
    }

    private Movie getMovie(Long id) {
        return movieRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(messageHelper.get("movie.notfound"))
        );
    }
}
