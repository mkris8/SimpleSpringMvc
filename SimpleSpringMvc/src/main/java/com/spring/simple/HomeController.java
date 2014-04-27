package com.spring.simple;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping(value = "/pageone", method = RequestMethod.GET)
	public String pageOne(Locale locale, Model model) {
		return "pageone";
	
	}

	@RequestMapping(value = "/pageone/pagetwo", method = 	RequestMethod.GET)
	public String pageTwo(Model model){
		return "pagetwo";
	}
	
	@RequestMapping(value = "/pageone/pagetwo/pagethree", method = RequestMethod.GET)
	public String pageThree(Model model){
		return "pagethree";
	}

	//how to pass params in the request
	@RequestMapping(value = "/pageone/getparamfromrqst", method = RequestMethod.GET)
	public String pageParamFromRequest(Model model, @RequestParam String userInput ){
		
		//set the param value to the model
		model.addAttribute("userInputValue", userInput);
		return "getparamfromrqst";
	}
	
	//alternatiive - RESTful way to pass in the params using @PathVariable
	
	@RequestMapping(value = "/pageone/getparamfromrqstbypath/{userInput}", method = RequestMethod.GET)
	public String getParamfromRqstbyPath(Model model, @PathVariable String userInput){
		model.addAttribute("userInputValue", userInput);
		return "getparamfromrqstbypath";
	}
	
}
