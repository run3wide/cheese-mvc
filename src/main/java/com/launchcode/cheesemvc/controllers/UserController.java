package com.launchcode.cheesemvc.controllers;

import com.launchcode.cheesemvc.dao.UserData;
import com.launchcode.cheesemvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @RequestMapping(value = "/add")
    public static String displayAddUser(Model model) {
        return "user/add";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public static String processAddUser(@ModelAttribute User user) {

        UserData.addUser(user);
        return "redirect:";
    }

    @RequestMapping(value = "")
    public static String index(Model model) {
        List<User> users = UserData.getUsers();
        model.addAttribute("users", users);
        return "user/index";
    }

}
