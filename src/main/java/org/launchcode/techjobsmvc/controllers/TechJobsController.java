package org.launchcode.techjobsmvc.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;

public class TechJobsController {
    static HashMap<String, String> actionChoices = new HashMap<>();

    public TechJobsController(){

    }

    @ModelAttribute("actions")
    static HashMap<String, String> getActionChoices(){
        HashMap<String,String> actions = new HashMap<>();
       
        return actions;
    }
}
