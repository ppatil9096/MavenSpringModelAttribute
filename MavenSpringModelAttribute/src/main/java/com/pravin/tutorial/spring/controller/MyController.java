package com.pravin.tutorial.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    /*
     ******** Example of using @ModelAttribute on a method*******
     * 
     * The following handler adds a single attribute ( i.e. 'countries') to model
     * implicitly by returning it
     */
    @ModelAttribute("countries")
    public List<String> populateCities() {
	List<String> countries = new ArrayList<>();
	countries.add("India");
	countries.add("SriLanka");
	countries.add("Nepal");
	return countries;
    }
    /*
     * *******Example of using @ModelAttribute on a method*******
     * 
     * The following handler method accept a model and add multiple attribute to it
     */

    @ModelAttribute
    public void populateCitiesAndLanguages(Model model) {

	List<String> cities = new ArrayList<>();
	cities.add("Pune");
	cities.add("Delhi");
	cities.add("Kathmandu");
	cities.add("Mumbai");
	cities.add("Colambo");

	List<String> languages = new ArrayList<>();
	languages.add("Hindi");
	languages.add("Sihani");
	languages.add("Nepali");
	model.addAttribute("languages", languages);
	model.addAttribute("cities", cities);
    }

    @RequestMapping("/")
    public String initView(@ModelAttribute("countries") List<String> countries,
	    @ModelAttribute("cities") List<String> cities, @ModelAttribute("languages") List<String> languages,
	    Model model) {
	countries.add("AUSSIE");
	countries.add("USA");

	cities.add("SIDNEY");
	cities.add("NEW YORK");

	languages.add("English");
	languages.add("Marathi");

	model.addAttribute("message", "This is ME!!!");
	return "main";
    }
}
