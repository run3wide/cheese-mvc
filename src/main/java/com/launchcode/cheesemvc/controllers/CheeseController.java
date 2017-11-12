package com.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    @RequestMapping(value = "")
    public String index(Model model) {

        List<String> cheeses = new ArrayList();
        cheeses.add("parmesan");
        cheeses.add("gouda");
        cheeses.add("cheddar");

        model.addAttribute("title", "My Cheeses");
        model.addAttribute("cheeses", cheeses);

        return "cheese/index";
    }
}
