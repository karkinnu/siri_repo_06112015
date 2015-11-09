package fi.javaee.siri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class SiriController {

	@RequestMapping(method = RequestMethod.GET)
	public String welcomePage(Model model) {
		System.out.println("*** WELCOME ***");
		return "welcome";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		return "login";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model) {
		return "admin";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String userPage(Model model) {
		return "main";
	}

}
