package org.launchcode.techjobsmvc.controllers;

import org.launchcode.techjobsmvc.models.Job;
import org.launchcode.techjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

import static org.launchcode.techjobsmvc.controllers.ListController.columnChoices;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @GetMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.


//    value = results is actually search/results because it is a part of RequestMapping "search" branch
    @PostMapping (value = "results")
    public String displaySearchResults(Model model, @RequestParam(name = "searchType") String searchType, @RequestParam(name = "searchTerm") String searchTerm)  {
        ArrayList<Job> jobs; // Create an ArrayList to store the search results

//        will need to test this code and the code added to search.html after whitelabel error gets fixed.
        if (searchTerm.equals("all") || searchTerm.isEmpty()) {
            // If the user enters "all" or leaves the search box empty, call findAll()
            jobs = JobData.findAll();
        } else {
            // If the search term is not "all" or empty, send it to findByColumnAndValue
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        }
        model.addAttribute("searchResults", jobs);
        return "search"; // returns search.html template, so it just reloads the page
    }
}