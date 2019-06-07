package pl.coderslab.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user";
    }


    @PostMapping("/add")
    public String addUser(@ModelAttribute @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user";
        }
        userService.saveUser(user);
        return "redirect:../";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        model.addAttribute("userSession", null);
        session.invalidate();
        return "redirect:../";
    }
}



