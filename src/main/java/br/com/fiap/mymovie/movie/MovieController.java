package br.com.fiap.mymovie.movie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public String index(Model model){
        var movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "index";
    }
}
