package com.launchcode.cheesemvc.controllers;

import com.launchcode.cheesemvc.dao.CheeseData;
import com.launchcode.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "My Cheeses");
        model.addAttribute("cheeses", CheeseData.getCheeses());

        return "cheese/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute Cheese cheese) {
        CheeseData.cheeses.put(cheese.getId(), cheese);
        return "redirect:";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String displayDeleteCheeseForm(Model model) {
        model.addAttribute("title", "Remove Cheese");
        model.addAttribute("cheeses", CheeseData.getCheeses());
        return "cheese/remove";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String deleteCheese(@RequestParam int[] cheeseIds) {
        for (int cheeseId : cheeseIds) {
            CheeseData.removeCheeseById(cheeseId);
        }

        return "redirect:";
    }
}
