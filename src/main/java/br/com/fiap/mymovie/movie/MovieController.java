package br.com.fiap.mymovie.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;


    @GetMapping
    public String index(Model model){
        var movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "index";
    }

    @GetMapping("/formMovie")
    public String form(Model model){
        model.addAttribute("movie", new Movie());
        return "/formMovie";
    }

    @PostMapping("/formMovie")
    public String create(Movie movie, RedirectAttributes redirectAttributes){
        movieService.save(movie);
        redirectAttributes.addFlashAttribute("message", "Movie created successfully");
        return "redirect:/movie";
    }
}
