package shafin.temp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import shafin.temp.entity.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shafin
 * @since 2/13/18
 */
@Controller
public class UserController {


    @GetMapping("/")
    public String getHome(ModelMap model) {
        List<Post> postList = new ArrayList<>();
        model.addAttribute("postList", postList);

        return "home";
    }
}
