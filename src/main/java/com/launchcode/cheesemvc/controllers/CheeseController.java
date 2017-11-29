package com.launchcode.cheesemvc.controllers;

import com.launchcode.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    static List<Cheese> cheeses = new ArrayList<>();

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "My Cheeses");
        model.addAttribute("cheeses", cheeses);

        return "cheese/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {
        Cheese cheese = new Cheese().setName(cheeseName).setDescription(cheeseDescription);
        cheeses.add(cheese);
        return "redirect:";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String displayDeleteCheeseForm(Model model) {
        model.addAttribute("title", "Remove Cheese");
        model.addAttribute("cheeses", cheeses);
        return "cheese/remove";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String deleteCheese(@RequestParam String cheeseName) {
        List<Cheese> cheeseCopy = new ArrayList<>(cheeses);

        for (Cheese cheese : cheeses) {
            if (cheese.getName().equals(cheeseName)) {
                cheeseCopy.remove(cheese);
            }
        }

        cheeses = cheeseCopy;

        return "redirect:";
    }
}
