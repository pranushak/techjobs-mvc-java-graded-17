package org.launchcode.techjobsmvc.controllers;

import org.launchcode.techjobsmvc.models.Job;
import org.launchcode.techjobsmvc.models.JobData;
import org.launchcode.techjobsmvc.models.Location;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static org.launchcode.techjobsmvc.controllers.ListController.columnChoices;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController extends TechJobsController {

    @GetMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.
    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam(required = false) String searchTerm){
        ArrayList<Job> jobs;
        if(searchType.equals("all") && (searchTerm.isEmpty() || searchTerm.isBlank())){
            jobs = JobData.findAll();
            model.addAttribute("title", "Jobs With " + searchType+":");
            model.addAttribute("searchType", searchType);
        }else {

            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        }
        model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("jobs", jobs);
        model.addAttribute("No Results", "No results");
        return "search";
    }
//    @GetMapping("byLocation")
//    public String searchByLocation(Model model, @RequestParam("location") String location){
//        ArrayList<Job> jobs = JobData.findByValue(location);
//        model.addAttribute("jobs", jobs);
//        return "list-jobs";
//    }
//    @GetMapping("byEmployer")
//    public String searchByEmployer(Model model, @RequestParam("employer") String employer){
//        ArrayList<Job> jobs = JobData.findByValue(employer);
//        model.addAttribute("jobs", jobs);
//        return "list-jobs";
//    }
//    @GetMapping("byPositionType")
//    public String searchByPositionType(Model model, @RequestParam("positionType") String positionType){
//        ArrayList<Job> jobs = JobData.findByValue(positionType);
//        model.addAttribute("jobs", jobs);
//        return "list-jobs";
//    }
//    @GetMapping("bySkill")
//    public String searchBySkill(Model model, @RequestParam("coreCompetency") String coreCompetency){
//        ArrayList<Job> jobs = JobData.findByValue(coreCompetency);
//        model.addAttribute("jobs", jobs);
//        return "list-jobs";
//    }

}

