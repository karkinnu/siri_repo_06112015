package fi.javaee.siri.controller;

import java.util.ArrayList;
import java.util.List;

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
import fi.javaee.siri.user.UserRole;

@Controller
@RequestMapping(value = "/")
public class SiriController {

	@Inject
	private UserDAO userDAO;

	// 1. sivu - tervetuloa
	@RequestMapping(method = RequestMethod.GET)
	public String welcomePage(Model model) {
		return "welcome";
	}

	// testi sivu
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String loginPage(Model model) {
		return "test";
	}

	// login - lomakkeen luominen
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Model model) {
		System.out.println("delete");
		userDAO.deleteUser("Dummy");
		
		User user = new User();
		
		user.setUsername("Dummy");
		user.setPassword("Dummy");
		user.setEnabled(true);
		user.setRole_admin(true);
		user.setRole_dbadmin(true);
		user.setRole_user(true);
		
		System.out.println("save");
		userDAO.saveUser(user);
		System.out.println("*****login *****");
		user = new User();
		model.addAttribute("user", user);
		return "login";
	}

	// kayttajan tunnistus
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkUser(@ModelAttribute(value = "user") @Valid User user, BindingResult result) {
		System.out.println("Username: " + user.getUsername() + " password: " + user.getPassword());
		String nextPage = "main";
		User user2 = userDAO.findByUserName(user.getUsername());

		StandardPasswordEncoder encoder = new StandardPasswordEncoder();

		if (user2 != null) {
			if (encoder.matches(user.getPassword(), user2.getPassword())) { // kirjoitettu
																			// ss,
																			// taulusta
																			// kryptattu
																			// ss

			} else {
				// model.addAttribute("error", "Invalid password");
				nextPage = "403";
			}
		} else {
			// model.addAttribute("error", "User not found");
			nextPage = "403";
		}
		return nextPage;
	}

	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// public String loginPage(Model model) {
	// return "login";
	// }

	// paakayttajan sivu
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model) {
		return "admin";
	}

	// paasivu
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String userPage(Model model) {
		return "main";
	}

	// logout
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutForm(Model model) {
		return "welcome";
	}

}
