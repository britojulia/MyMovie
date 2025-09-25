package br.com.fiap.mymovie.toWatch;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/towatch")
public class ToWatchController {

    private final ToWatchService toWatchService;

    public ToWatchController(ToWatchService toWatchService) {
        this.toWatchService = toWatchService;
    }
    public String index(Model model) {
        var towatchs = toWatchService.getAllToWatch();
        model.addAttribute("towatchs", towatchs);
        return "index";
    }

}
