package fi.javaee.siri.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.javaee.siri.user.User;
import fi.javaee.siri.user.UserDAO;

@Controller
@RequestMapping(value = "/")
public class SiriController {

	@Inject
	private UserDAO userDAO;

	// tervetuloa (1. sivu)
	@RequestMapping(method = RequestMethod.GET)
	public String welcomePage(Model model) {
		return "welcome";
	}

	// testi sivu
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String loginPage(Model model) {
		return "test";
	}

	// Login lomakkeen luominen
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Model model) {
		System.out.println("delete");
		userDAO.deleteUser("Dummy");
		User x = new User("Dummy", "Dummy", true);
		System.out.println("save");
		userDAO.saveUser(x);
		System.out.println("*****login *****");
		User u = new User();
		model.addAttribute("user", u);
		return "login";
	}

	// Käyttäjän tunnistus
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkUser( @ModelAttribute(value="user") @Valid User user, BindingResult result) {
		System.out.println("Username: "+user.getUsername()+ " password: "+user.getPassword());
		String nextPage = "main";
		User user2 = userDAO.findByUserName(user.getUsername());

		StandardPasswordEncoder encoder = new StandardPasswordEncoder();				

		if (user2!=null){
			if ( encoder.matches(user.getPassword(), user2.getPassword() ) ){  // kirjoitettu ss, taulusta kryptattu ss

			}
			else{		
				//model.addAttribute("error", "Invalid password");
				nextPage = "403";
			}
		}
		else {
			//model.addAttribute("error", "User not found");
			nextPage="403";
		}
		return nextPage;
	}

//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String loginPage(Model model) {
//		return "login";
//	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model) {
		return "admin";
	}

	// pääsivu
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String userPage(Model model) {
		return "main";
	}

}
