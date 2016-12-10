package shafin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import shafin.web.entity.User;
import shafin.web.service.UserService;

import java.util.List;

/**
 * @author SHAFIN
 * @since 12/11/2016
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHome(Model model) {

        List<User> allUsers = userService.findAllUser();
        model.addAttribute("userList", allUsers);

        User user = new User("Shafin", "Dhaka");
        userService.insertUser(user);

        return "home";
    }
}
