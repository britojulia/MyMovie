package br.com.fiap.mymovie.toWatch;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/towatch")
@RequiredArgsConstructor
public class ToWatchController {

    private final ToWatchService toWatchService;

    @GetMapping
    public String index(Model model) {
        var towatchs = toWatchService.getAllToWatch();
        model.addAttribute("towatchs", towatchs);
        return "index";
    }

    @GetMapping("/formWatch")
    public String form(Model model){
        model.addAttribute("towatch", new ToWatch());
        return "formWatch";
    }

    @PostMapping("/formWatch")
    public String create(ToWatch toWatch, RedirectAttributes redirectAttributes){
        toWatchService.save(toWatch);
        redirectAttributes.addFlashAttribute("message", "To watch created successfully");
        return "redirect:/towatch";
    }

}
