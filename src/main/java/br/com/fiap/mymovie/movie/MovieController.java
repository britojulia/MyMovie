package br.com.fiap.mymovie.movie;

import br.com.fiap.mymovie.config.MessageHelper;
import br.com.fiap.mymovie.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final MessageSource messageSource;
    private final MessageHelper messageHelper;
    private final UserService userService;


    @GetMapping
    public String index(Model model, @AuthenticationPrincipal OAuth2User user){
        var movies = movieService.getAllMovies();
        model.addAttribute("user", user);
        model.addAttribute("movies", movies);
        return "index";
    }

    @GetMapping("/formMovie")
    public String form(Model model){
        model.addAttribute("movie", new Movie());
        return "/formMovie";
    }

    @PostMapping("/formMovie")
    public String create(@Valid Movie movie, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()) return "formMovie";

        var message = messageSource.getMessage("movie.create.success", null, LocaleContextHolder.getLocale());
        movieService.save(movie);
        redirectAttributes.addFlashAttribute("message", messageHelper.get("movie.create.success"));
        return "redirect:/movie";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect ){
        movieService.deleteById(id);
        redirect.addFlashAttribute("message", messageHelper.get("movie.delete.success"));
        return "redirect:/movie";
    }
}
