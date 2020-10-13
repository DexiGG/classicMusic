package music;

import exceptions.CustomerNotFoundException;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/music")//единая точка входа
public class MusicController {

    @GetMapping("/popMusic") //по новому формату Get запрос
    public String playPopMusic(@RequestParam(name = "author", required = false) String author,
                               @RequestParam(name="year", required = false) String year, Model model)
    {
        System.out.println("author " + author);

        System.out.println("year " + year);


        model.addAttribute("music_info", "PopMusic developed author by " + author + " from " + year);

        return "pop_music";

    }

    @GetMapping("/classicalMusic")
    public String playClassicMusic(HttpServletRequest httpServletRequest){

        String author = httpServletRequest.getParameter("author");

        String year = httpServletRequest.getParameter("year");


        System.out.println("author " + author);

        System.out.println("year " + year);






        return "classic_music";
    }


}
