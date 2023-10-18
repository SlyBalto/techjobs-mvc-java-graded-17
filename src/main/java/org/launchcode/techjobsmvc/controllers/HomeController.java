package org.launchcode.techjobsmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String index(Model model) {

//        hashmaps are like the maps from Javascript, with a key (k) and a value (v).
//        this lets us get Search and List without having to have perfect capitalization, makes the code easier to use.
        HashMap<String, String> actionChoices = new HashMap<>();
        actionChoices.put("search", "Search");
        actionChoices.put("list", "List");

        model.addAttribute("actions", actionChoices);

        return "index";
    }

}

